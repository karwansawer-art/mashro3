# AdhkarApp (Kotlin / Android)

هذا المستودع يحتوي على تطبيق أذكار مكتوب بلغة **Kotlin** لأندرويد.

## كيفية البناء محليًا
1. ثبت **Android Studio** (Arctic Fox أو أحدث) + **Android SDK**.
2. افتح المشروع في Android Studio.
3. من قائمة *Build* اختر **Make Project** ثم من *Build Variants* استعمل `debug`.
4. بناء ملف الـ APK عبر: **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
5. سيظهر مسار الملف داخل: `app/build/outputs/apk/debug/` (أو ما يقابله لو كان اسم الموديول مختلفًا).

> يتطلب JDK 17 عادةً للمشاريع الحديثة. إن واجهت مشكلة، جرّب JDK 17.

## التكامل مع GitHub Actions
أضفنا ملف عمل جاهز في: `.github/workflows/android-ci.yml` يقوم بما يلي:
- تثبيت JDK 17
- تشغيل `./gradlew assembleDebug`
- رفع مخرجات الـ APK كـ **Artifact** يمكن تنزيله من صفحة Actions

### طريقة الاستخدام
1. أنشئ مستودعًا عامًا على GitHub.
2. ادفع (push) الكود إلى الفرع `main` أو `master`.
3. انتقل إلى تبويب **Actions** > سير عمل **Android CI**.
4. عند نجاح البناء، افتح Job الأخير وستجد **Artifact** باسم `debug-apks` يحوي ملفات الـ APK.

## النشر على Google Play (اختياري)
- أنشئ توقيعًا (Keystore) ووقّع إصدار **release**.
- غيّر مهمة البناء إلى `assembleRelease` وأضف إعدادات التوقيع في `build.gradle` أو عبر *Play App Signing*.
- أنشئ حزمة **AAB** عبر `bundleRelease` إن كنت تريد الرفع إلى Play.

---

> ملاحظة: إن لم يوجد ملف `gradlew` في المشروع، أنشئ Wrapper عبر Android Studio أو عبر الأمر:
> ```bash
> gradle wrapper
> ```
> ثم ادفع ملفات الـ Wrapper للمستودع.
