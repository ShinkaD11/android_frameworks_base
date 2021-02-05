/*
 * Copyright (C) 2020 The Android Open Source Project
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

package android.content.pm.verify.domain;

import android.annotation.NonNull;
import android.annotation.SystemApi;
import android.content.Context;
import android.os.Parcelable;
import android.os.UserHandle;

import com.android.internal.util.DataClass;
import com.android.internal.util.Parcelling;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Contains the user selection state for a package. This means all web HTTP(S) domains
 * declared by a package in its manifest, whether or not they were marked for auto
 * verification.
 * <p>
 * By default, all apps are allowed to automatically open links with domains that they've
 * successfully verified against. This is reflected by {@link #isLinkHandlingAllowed()}.
 * The user can decide to disable this, disallowing the application from opening these
 * links.
 * <p>
 * Separately, independent of this toggle, the user can choose specific domains to allow
 * an app to open, which is reflected as part of {@link #getHostToUserSelectionMap()},
 * which maps the domain name to the true/false state of whether it was enabled by the user.
 * <p>
 * These values can be changed through the
 * {@link DomainVerificationManager#setDomainVerificationLinkHandlingAllowed(String,
 * boolean)} and
 * {@link DomainVerificationManager#setDomainVerificationUserSelection(UUID, Set,
 * boolean)} APIs.
 * <p>
 * Note that because state is per user, if a different user needs to be changed, one will
 * need to use {@link Context#createContextAsUser(UserHandle, int)} and hold the
 * {@link android.Manifest.permission#INTERACT_ACROSS_USERS} permission.
 *
 * @hide
 */
@SystemApi
@SuppressWarnings("DefaultAnnotationParam")
@DataClass(genAidl = true, genHiddenConstructor = true, genParcelable = true, genToString = true,
        genEqualsHashCode = true)
public final class DomainVerificationUserSelection implements Parcelable {

    /**
     * @see DomainVerificationInfo#getIdentifier
     */
    @NonNull
    @DataClass.ParcelWith(Parcelling.BuiltIn.ForUUID.class)
    private final UUID mIdentifier;

    /**
     * The package name that this data corresponds to.
     */
    @NonNull
    private final String mPackageName;

    /**
     * The user that this data corresponds to.
     */
    @NonNull
    private final UserHandle mUser;

    /**
     * Whether or not this package is allowed to open links.
     */
    @NonNull
    private final boolean mLinkHandlingAllowed;

    /**
     * Retrieve the existing user selection state for the matching
     * {@link #getPackageName()}, as was previously set by
     * {@link DomainVerificationManager#setDomainVerificationUserSelection(UUID, Set,
     * boolean)}.
     *
     * @return Map of hosts to enabled state for the given package and user.
     */
    @NonNull
    private final Map<String, Boolean> mHostToUserSelectionMap;



    // Code below generated by codegen v1.0.22.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/content/pm/domain/verify/DomainVerificationUserSelection.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * Creates a new DomainVerificationUserSelection.
     *
     * @param packageName
     *   The package name that this data corresponds to.
     * @param user
     *   The user that this data corresponds to.
     * @param linkHandlingAllowed
     *   Whether or not this package is allowed to open links.
     * @param hostToUserSelectionMap
     *   Retrieve the existing user selection state for the matching
     *   {@link #getPackageName()}, as was previously set by
     *   {@link DomainVerificationManager#setDomainVerificationUserSelection(UUID, Set,
     *   boolean)}.
     * @hide
     */
    @DataClass.Generated.Member
    public DomainVerificationUserSelection(
            @NonNull UUID identifier,
            @NonNull String packageName,
            @NonNull UserHandle user,
            @NonNull boolean linkHandlingAllowed,
            @NonNull Map<String,Boolean> hostToUserSelectionMap) {
        this.mIdentifier = identifier;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mIdentifier);
        this.mPackageName = packageName;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mPackageName);
        this.mUser = user;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mUser);
        this.mLinkHandlingAllowed = linkHandlingAllowed;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mLinkHandlingAllowed);
        this.mHostToUserSelectionMap = hostToUserSelectionMap;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mHostToUserSelectionMap);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * @see DomainVerificationInfo#getIdentifier
     */
    @DataClass.Generated.Member
    public @NonNull UUID getIdentifier() {
        return mIdentifier;
    }

    /**
     * The package name that this data corresponds to.
     */
    @DataClass.Generated.Member
    public @NonNull String getPackageName() {
        return mPackageName;
    }

    /**
     * The user that this data corresponds to.
     */
    @DataClass.Generated.Member
    public @NonNull UserHandle getUser() {
        return mUser;
    }

    /**
     * Whether or not this package is allowed to open links.
     */
    @DataClass.Generated.Member
    public @NonNull boolean isLinkHandlingAllowed() {
        return mLinkHandlingAllowed;
    }

    /**
     * Retrieve the existing user selection state for the matching
     * {@link #getPackageName()}, as was previously set by
     * {@link DomainVerificationManager#setDomainVerificationUserSelection(UUID, Set,
     * boolean)}.
     *
     * @return Map of hosts to enabled state for the given package and user.
     */
    @DataClass.Generated.Member
    public @NonNull Map<String,Boolean> getHostToUserSelectionMap() {
        return mHostToUserSelectionMap;
    }

    @Override
    @DataClass.Generated.Member
    public String toString() {
        // You can override field toString logic by defining methods like:
        // String fieldNameToString() { ... }

        return "DomainVerificationUserSelection { " +
                "identifier = " + mIdentifier + ", " +
                "packageName = " + mPackageName + ", " +
                "user = " + mUser + ", " +
                "linkHandlingAllowed = " + mLinkHandlingAllowed + ", " +
                "hostToUserSelectionMap = " + mHostToUserSelectionMap +
        " }";
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@android.annotation.Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(DomainVerificationUserSelection other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        DomainVerificationUserSelection that = (DomainVerificationUserSelection) o;
        //noinspection PointlessBooleanExpression
        return true
                && java.util.Objects.equals(mIdentifier, that.mIdentifier)
                && java.util.Objects.equals(mPackageName, that.mPackageName)
                && java.util.Objects.equals(mUser, that.mUser)
                && mLinkHandlingAllowed == that.mLinkHandlingAllowed
                && java.util.Objects.equals(mHostToUserSelectionMap, that.mHostToUserSelectionMap);
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + java.util.Objects.hashCode(mIdentifier);
        _hash = 31 * _hash + java.util.Objects.hashCode(mPackageName);
        _hash = 31 * _hash + java.util.Objects.hashCode(mUser);
        _hash = 31 * _hash + Boolean.hashCode(mLinkHandlingAllowed);
        _hash = 31 * _hash + java.util.Objects.hashCode(mHostToUserSelectionMap);
        return _hash;
    }

    @DataClass.Generated.Member
    static Parcelling<UUID> sParcellingForIdentifier =
            Parcelling.Cache.get(
                    Parcelling.BuiltIn.ForUUID.class);
    static {
        if (sParcellingForIdentifier == null) {
            sParcellingForIdentifier = Parcelling.Cache.put(
                    new Parcelling.BuiltIn.ForUUID());
        }
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mLinkHandlingAllowed) flg |= 0x8;
        dest.writeByte(flg);
        sParcellingForIdentifier.parcel(mIdentifier, dest, flags);
        dest.writeString(mPackageName);
        dest.writeTypedObject(mUser, flags);
        dest.writeMap(mHostToUserSelectionMap);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ DomainVerificationUserSelection(@NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        boolean linkHandlingAllowed = (flg & 0x8) != 0;
        UUID identifier = sParcellingForIdentifier.unparcel(in);
        String packageName = in.readString();
        UserHandle user = (UserHandle) in.readTypedObject(UserHandle.CREATOR);
        Map<String,Boolean> hostToUserSelectionMap = new java.util.LinkedHashMap<>();
        in.readMap(hostToUserSelectionMap, Boolean.class.getClassLoader());

        this.mIdentifier = identifier;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mIdentifier);
        this.mPackageName = packageName;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mPackageName);
        this.mUser = user;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mUser);
        this.mLinkHandlingAllowed = linkHandlingAllowed;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mLinkHandlingAllowed);
        this.mHostToUserSelectionMap = hostToUserSelectionMap;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mHostToUserSelectionMap);

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<DomainVerificationUserSelection> CREATOR
            = new Parcelable.Creator<DomainVerificationUserSelection>() {
        @Override
        public DomainVerificationUserSelection[] newArray(int size) {
            return new DomainVerificationUserSelection[size];
        }

        @Override
        public DomainVerificationUserSelection createFromParcel(@NonNull android.os.Parcel in) {
            return new DomainVerificationUserSelection(in);
        }
    };

    @DataClass.Generated(
            time = 1611799495498L,
            codegenVersion = "1.0.22",
            sourceFile = "frameworks/base/core/java/android/content/pm/domain/verify/DomainVerificationUserSelection.java",
            inputSignatures = "private final @android.annotation.NonNull @com.android.internal.util.DataClass.ParcelWith(com.android.internal.util.Parcelling.BuiltIn.ForUUID.class) java.util.UUID mIdentifier\nprivate final @android.annotation.NonNull java.lang.String mPackageName\nprivate final @android.annotation.NonNull android.os.UserHandle mUser\nprivate final @android.annotation.NonNull boolean mLinkHandlingAllowed\nprivate final @android.annotation.NonNull java.util.Map<java.lang.String,java.lang.Boolean> mHostToUserSelectionMap\nclass DomainVerificationUserSelection extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genAidl=true, genHiddenConstructor=true, genParcelable=true, genToString=true, genEqualsHashCode=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
