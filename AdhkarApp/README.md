# AdhkarApp (Kotlin / Android)

هذا المستودع يحتوي على تطبيق أذكار مكتوب بلغة **Kotlin** لأندرويد.

> ملاحظة مهمة: ملفات المشروع داخل مجلد **AdhkarApp/**. تم إعداد CI للدخول لهذا المجلد تلقائيًا.

## البناء عبر GitHub Actions
- يقوم سير العمل في `.github/workflows/android-ci.yml` بمحاولة توليد Gradle Wrapper تلقائيًا إن لم يكن موجودًا (Best-effort).
- ثم يبني إصدار **Debug** ويرفع ملفات **APK** كـ Artifact.

## البناء محليًا
1. افتح المجلد `AdhkarApp/` في Android Studio.
2. تأكد من وجود Gradle Wrapper (`gradlew`). إن لم يوجد: من *Gradle Tool Window* شغّل مهمة `wrapper` أو استعمل `gradle wrapper`.
3. ابنِ إصدار debug: **Build > Build APK(s)**. المسار المتوقع: `app/build/outputs/apk/debug/`.
