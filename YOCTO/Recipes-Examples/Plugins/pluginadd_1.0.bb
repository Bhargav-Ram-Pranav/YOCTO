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
           file://gst-plugin/AUTHORS \
           file://gst-plugin/ChangeLog \
           file://gst-plugin/COPYING \
           file://gst-plugin/meson.build \
           file://gst-plugin/src/gstaudiofilter.c \
           file://gst-plugin/src/gstcroptech.c \
           file://gst-plugin/src/gstcroptech.h \
           file://gst-plugin/src/gstplugin.c \
           file://gst-plugin/src/gstplugin.h \
           file://gst-plugin/src/gsttransform.c \
           file://gst-plugin/src/gsttransform.h \
           file://gst-plugin/src/my_own_headers.h \
           file://meson.build \
           file://README.md"

INHIBIT_PACKAGE_STRIP = "1"

S = "${WORKDIR}"


inherit meson pkgconfig



FILES:${PN} += "${libdir}/gstreamer-1.0/libgstcroptech.so \
                ${libdir}/gstreamer-1.0/libgstplugin.so \
                ${libdir}/gstreamer-1.0/libgstaudiofilterexample.so"

#FILES:${PN} += "${libdir}/*"


