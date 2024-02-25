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
RDEPENDS:${PN} += "gstreamer1.0"

SRC_URI = "file://COPYING \
           file://CMakeLists.txt \
           file://build/gstcroptech.c \
           file://build/gstcroptech.h "
           

INHIBIT_PACKAGE_STRIP = "1"

S = "${WORKDIR}"


inherit cmake



FILES:${PN} += "${libdir}/gstreamer-1.0/libcroptech.so"




