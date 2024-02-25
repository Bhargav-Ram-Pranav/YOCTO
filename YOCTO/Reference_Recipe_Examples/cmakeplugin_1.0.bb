#helloworld-c application
SUMMARY = "helloworld of Autotools recipe"
DESCRIPTION = "My hello world application"
SUMMARY = "GStreamer Croptech Plugin"
DESCRIPTION = "A custom GStreamer plugin for Croptech application"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit cmake

DEPENDS += "pkgconfig"
DEPENDS += "cmake-native"
DEPENDS += "gstreamer1.0 "
DEPENDS += "gstreamer1.0-plugins-good"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-base"
RDEPENDS_${PN} += "gstreamer1.0"

FILESEXTRAPATHS_prepend := "${THISDIR}/:"

SRC_URI = "file://CMakeLists.txt \
           file://build/gstcroptech.c \
           file://build/gstcroptech.h \
           file://build/my_own_headers.h "
           
S = "${WORKDIR}"


FILES:${PN} += "${libdir}/libgstcroptech.so"
