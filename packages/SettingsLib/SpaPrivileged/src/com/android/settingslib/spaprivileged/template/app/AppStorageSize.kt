/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settingslib.spaprivileged.template.app

import android.content.Context
import android.content.pm.ApplicationInfo
import android.text.format.Formatter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.android.settingslib.spaprivileged.R
import com.android.settingslib.spaprivileged.framework.common.storageStatsManager
import com.android.settingslib.spaprivileged.model.app.userHandle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ApplicationInfo.getStorageSize(): State<String> {
    val context = LocalContext.current
    return produceState(initialValue = stringResource(R.string.summary_placeholder)) {
        withContext(Dispatchers.IO) {
            value = Formatter.formatFileSize(context, calculateSizeBytes(context))
        }
    }
}

private fun ApplicationInfo.calculateSizeBytes(context: Context): Long {
    val storageStatsManager = context.storageStatsManager
    val stats = storageStatsManager.queryStatsForPackage(storageUuid, packageName, userHandle)
    return stats.codeBytes + stats.dataBytes + stats.cacheBytes
}
