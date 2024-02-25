SUMMARY = "Custom GStreamer Plugin"
DESCRIPTION = "Description of your custom GStreamer plugin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://CMakeLists.txt \
           file://build/gstcroptech.c \
           file://build/gstcroptech.h \
           file://build/my_own_headers.h"

S = "${WORKDIR}"

inherit cmake

DEPENDS += "gstreamer1.0 "
DEPENDS += "gstreamer1.0-plugins-good"


do_configure_prepend() {
    # Additional steps before configuring (if needed)
    cd ${S}
    
}

do_compile:prepend() {
    # Change to the build directory
    cmake -B build
    cd ${S}/build
}

do_compile() {
    # Compile using make
    oe_runmake
}

do_install() {
    # Install using make
    # oe_runmake install DESTDIR=${D}
    cp libcroptech.so /usr/lib
}

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"

