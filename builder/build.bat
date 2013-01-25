@REM ==========================================
@REM 将jar/swc打包成ANE文件
@REM 作者：zrong
@REM 日期：2012-6-7
@REM ==========================================
@REM
@REM
SET FLEX_ADT=java -jar D:\flex_sdks\4.6.0\lib\adt.jar
@REM 生成的ANE目标路径
SET ANE_TARGET=ANEToolkit.ane
@REM SWC的路径
SET ANE_SWC=..\swc\bin\ANEToolkit.swc
@REM JAR的路径
SET ANE_JAR=..\androidANE\bin\AndroidANE.jar
@REM 解压缩SWC的命令行，这里用HaoZipC，可以替换成其他任何unzip命令
SET ZIP_CMD=d:\PortableApps\HaoZip\HaoZipC.exe x -oAndroid-ARM\ -y %ANE_SWC%
%ZIP_CMD%
copy /B /Y %ANE_JAR% Android-ARM\
del Android-ARM\catalog.xml

@REM 开始打包ANE
%FLEX_ADT% -package -target ane %ANE_TARGET% extension.xml -swc %ANE_SWC% -platform Android-ARM -C ./Android-ARM/ . -platform default -C ./Android-ARM/ library.swf

@REM 复制打包后的ANE到目标lib
copy /B /Y %ANE_TARGET% ..\aneTest\libs