# We use ProGuard for optimizations, obfuscation is for those who have sth to hide
-dontobfuscate
-optimizations !code/allocation/variable

# We're referencing stuff that is unknown to the system
-libraryjar ../extern/UnifiedNlp/unifiednlp-compat/build/classes/main
-dontwarn java.awt.**
-dontwarn javax.annotation.**

# OkIO, OkHttp
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn org.oscim.tiling.source.OkHttpEngine
-dontwarn org.oscim.tiling.source.OkHttpEngine$OkHttpFactory

# Disable ProGuard Notes, they won't help here
-dontnote

# Keep dynamically loaded GMS classes
-keep public class com.mgoogle.android.gms.maps.internal.CreatorImpl { public *; }
-keep public class com.mgoogle.android.gms.common.security.ProviderInstallerImpl { public *; }
-keep public class com.mgoogle.android.gms.plus.plusone.PlusOneButtonCreatorImpl { public *; }

# Keep AutoSafeParcelables
-keep public class * extends org.microg.safeparcel.AutoSafeParcelable {
    @org.microg.safeparcel.SafeParceled *;
}

# Keep asInterface method cause it's accessed from SafeParcel
-keepattributes InnerClasses
-keepclassmembers interface * extends android.os.IInterface {
    public static class *;
}
-keep public class * extends android.os.Binder { public static *; }

# Keep library info
-keep class **.BuildConfig { *; }

# Keep protobuf class builders
-keep public class * extends com.squareup.wire.Message
-keep public class * extends com.squareup.wire.Message$Builder { public <init>(...); }
