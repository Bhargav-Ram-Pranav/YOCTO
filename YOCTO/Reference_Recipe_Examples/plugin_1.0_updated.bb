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

do_configure_prepend() {
    # No need to create a build directory; it will be created by CMake
}

do_configure() {
    # Configure using CMake
    cmake \
        -DCMAKE_INSTALL_PREFIX=${prefix} \
        -DCMAKE_INSTALL_LIBDIR=lib \
        -DCMAKE_TOOLCHAIN_FILE=${COREBASE}/meta/cmake/toolchainfile.cmake \
        ${EXTRA_OECMAKE}
}

do_compile() {
    # Navigate to the build directory and run make
    #cd ${S}/build
     cd ${B}
    oe_runmake
}

do_install() {
    # Install to the destination directory
    oe_runmake DESTDIR=${D} -C ${S}/build install

    # Copy the library to /usr/lib/ (adjust paths as needed)
    install -d ${D}${base_libdir}
    install -m 0644 ${D}${libdir}/gstreamer-1.0/*.so ${D}${base_libdir}
}

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
