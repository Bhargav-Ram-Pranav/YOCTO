SUMMARY = "Gstreamer own plugin"
HOMEPAGE = "https://gitlab.com/BhargavRamPranav/GSTREAMER_PLUGINS"

SECTION = "video cropping"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


DEPENDS += "pkgconfig"
DEPENDS += "cmake-native"
DEPENDS += "gstreamer1.0 "
DEPENDS += "gstreamer1.0-plugins-good"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-base"
DEPENDS += "ninja"
DEPENDS += "make"

RDEPENDS:${PN} += "gstreamer1.0"

EXTRA_OEMAKE = "-d"
EXTRA_OECMAKE += "-G 'Unix Makefiles'"

EXTRA_OECMAKE = "-DCMAKE_VERBOSE_MAKEFILE:BOOL=ON"

SRC_URI = "file://COPYING \
           file://CMakeLists.txt \
           file://build/CMakeLists.txt \
           file://build/gstcroptech.c \
           file://build/gstcroptech.h \
           file://build/my_own_headers.h "
           
#install(TARGETS croptech DESTINATION ${CMAKE_INSTALL_LIBDIR}/gstreamer-1.0)

INHIBIT_PACKAGE_STRIP = "1"

S = "${WORKDIR}"


inherit cmake pkgconfig
do_compile() {
oe_runmake
}
do_install() {
    oe_runmake install DESTDIR=${D}
    install -d ${D}${libdir}/gstreamer-1.0/
    install -m 0755 ${B}/lincroptech.so ${D}${libdir}/gstreamer-1.0/
}


FILES:${PN} += "${libdir}/gstreamer-1.0/libcroptech.so"




