@echo off
echo decompile start
cd data
rmdir /s/q demo
rmdir /s/q shell
call apktool d demo.apk
call apktool d shell.apk
cd ..
echo decompile end