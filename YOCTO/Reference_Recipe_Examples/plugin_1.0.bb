SUMMARY = "Custom GStreamer Plugin"
DESCRIPTION = "Description of your custom GStreamer plugin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://CMakeLists.txt \
           file://gstcroptech.c \
           file://gstcroptech.h \
           file://my_own_headers.h"

S = "${WORKDIR}"

inherit cmake

DEPENDS += "gstreamer1.0"

do_configure() {
    # You can add any additional configuration steps here if needed
    oe_runmake -C ${S}
}

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"

