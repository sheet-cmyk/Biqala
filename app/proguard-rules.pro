# Add project specific ProGuard rules here.

# Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep class com.grocery.app.data.remote.dto.** { *; }

# Gson
-keep class com.google.gson.** { *; }

# Hilt
-keep class dagger.hilt.** { *; }

# Firebase
-keep class com.google.firebase.** { *; }
