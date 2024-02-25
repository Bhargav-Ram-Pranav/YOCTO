#helloworld-c application
SUMMARY = "helloworld of Autotools recipe"
DESCRIPTION = "My hello world application"
SUMMARY = "GStreamer Croptech Plugin"
DESCRIPTION = "A custom GStreamer plugin for Croptech application"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"



DEPENDS += "pkgconfig"
DEPENDS += "cmake-native"
DEPENDS += "cmake"
DEPENDS += "gstreamer1.0 "
DEPENDS += "glib-2.0"
DEPENDS += "gstreamer1.0-plugins-good"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-base"
RDEPENDS_${PN} += "gstreamer1.0"



SRC_URI = "file://CMakeLists.txt \
	   file://src/CMakeLists.txt \
           file://src/gstcroptech.c \
           file://src/gstcroptech.h \
           file://src/my_own_headers.h "


S="${WORKDIR}"

inherit pkgconfig cmake

EXTRA_OECMAKE = ""
FILES_${PN} += "${libdir}/libcroptech.so"








