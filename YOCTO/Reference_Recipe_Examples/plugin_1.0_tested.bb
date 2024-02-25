
SUMMARY = "GStreamer Croptech Plugin"
DESCRIPTION = "A custom GStreamer plugin for Croptech application"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://CMakeLists.txt \
           file://build/gstcroptech.c \
           file://build/gstcroptech.h \
           file://build/my_own_headers.h"

S = "${WORKDIR}"

DEPENDS += "cmake-native"
DEPENDS += "gstreamer1.0 "
DEPENDS += "gstreamer1.0-plugins-good"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-base"
inherit cmake

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=${prefix}"

do_install_append() {
    install -d ${D}${libdir}/gstreamer-1.0
    install -m 0644 ${B}/libcroptech.so ${D}${libdir}/gstreamer-1.0
}

FILES_${PN} += "${libdir}/gstreamer-1.0/libcroptech.so"

