SUMMARY = "GStreamer Template Plugin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=bba6cdb9c2b03c849ed4975ed9ed90dc"

SRC_URI = "file://gst-template"

S = "${WORKDIR}"
DEPENDS += "gstreamer1.0"
inherit meson

do_configure_prepend() {
    # Meson build files often include license information
    cp ${S}/COPYING ${S}/COPYING.MIT
}

do_compile() {
    meson_compile
}

do_install() {
    meson_install
}

FILES_${PN} += "${libdir}/gstreamer-1.0/"
