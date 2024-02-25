SUMMARY = "Tool to assist in network address calculations for IPv4 and IPv6."
HOMEPAGE = "https://gitlab.com/ipcalc/ipcalc"

SECTION = "net"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
#DEPENDS += "cmake"
DEPENDS += "pkgconfig cmake gstreamer1.0"

RDEPENDS_${PN} += "gstreamer1.0"

# You can also specify additional Meson options as needed
# EXTRA_OEMESON += " -Dsome_option=enabled"
DEPENDS += "cmake-native"
DEPENDS += "gstreamer1.0 "
DEPENDS += "gstreamer1.0-plugins-good"
DEPENDS += "gstreamer1.0-plugins-bad"
DEPENDS += "gstreamer1.0-plugins-base"
# Package Name
PN = "mesonconfig"

#EXTRA_OECMAKE += "-DGSTREAMER_VIDEO_1_0_SUBPROJECT=<path-to-fallback-subproject>"

#SRC_URI = "file://*"
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

SRCREV = "4c4261a47f355946ee74013d4f5d0494487cc2d6"

S = "${WORKDIR}"
FILES:${PN} += "${libdir}/gstreamer-1.0/*.so"
inherit meson pkgconfig 


