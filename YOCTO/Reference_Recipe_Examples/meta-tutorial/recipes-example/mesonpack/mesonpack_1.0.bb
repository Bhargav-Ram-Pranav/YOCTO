SUMMARY = "Tool to assist in network address calculations for IPv4 and IPv6."
HOMEPAGE = "https://gitlab.com/ipcalc/ipcalc"

SECTION = "net"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "file://*"
SRCREV = "4c4261a47f355946ee74013d4f5d0494487cc2d6"

S = "${WORKDIR}"

inherit meson
