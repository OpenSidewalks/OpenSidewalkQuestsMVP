%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as de.tcat.opensidewalks chmod 777 /data/data/de.tcat.opensidewalks/databases/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as de.tcat.opensidewalks chmod 777 /data/data/de.tcat.opensidewalks/databases/streetcomplete.db
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/de.tcat.opensidewalks/databases/streetcomplete.db /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/streetcomplete.db streetcomplete.db
"C:\Program Files\DB Browser for SQLite\DB Browser for SQLite.exe" streetcomplete.db
del streetcomplete.db