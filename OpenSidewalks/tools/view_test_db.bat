%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as de.tcat.opensidewalks chmod 777 /data/data/de.tcat.opensidewalks/databases/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as de.tcat.opensidewalks chmod 777 /data/data/de.tcat.opensidewalks/databases/test_streetcomplete.db
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/de.tcat.opensidewalks/databases/test_streetcomplete.db /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/test_streetcomplete.db test_streetcomplete.db
"C:\Program Files\DB Browser for SQLite\DB Browser for SQLite.exe" test_streetcomplete.db
del test_streetcomplete.db