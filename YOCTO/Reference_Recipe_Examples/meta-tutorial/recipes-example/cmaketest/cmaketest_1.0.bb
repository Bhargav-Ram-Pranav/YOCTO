#helloworld-c application
SUMMARY = "helloworld of Autotools recipe"
DESCRIPTION = "My hello world application"
SUMMARY = "GStreamer Croptech Plugin"
DESCRIPTION = "A custom GStreamer plugin for Croptech application"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit cmake

FILESEXTRAPATHS_prepend := "${THISDIR}/:"

SRC_URI = "file://CMakeLists.txt \
           file://cmaketest.c"
S = "${WORKDIR}"


FILES_${PN} = "${bindir}/"
