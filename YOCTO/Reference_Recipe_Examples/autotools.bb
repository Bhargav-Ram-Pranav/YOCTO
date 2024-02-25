SUMMARY = "GStreamer Croptech Plugin"
DESCRIPTION = "A custom GStreamer plugin for Croptech application"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS += "gstreamer1.0-plugins-good"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-base"
RDEPENDS_${PN} += "gstreamer1.0"

SRC_URI = "file://configure.ac \
           file://Makefile.am \
           file://src/gstcroptech.c \
           file://src/gstcroptech.h \
           file://src/my_own_headers.h "

S = "${WORKDIR}"

inherit autotools

FILES_${PN} += "${libdir}/gstreamer-1.0/libcroptech.so"

