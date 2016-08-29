DESCRIPTION = "QT wrapper for zxing lib"

require qxzing.inc

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}"

DEPENDS = "qtbase qtquick1"

QMAKE_PROFILES = "${S}/source/QZXing.pro"

do_install_append () {
	install -m 755 -d ${D}/${includedir}
	install -m 644 ${S}/source/QZXing.h ${D}/${includedir}
	install -m 644 ${S}/source/QZXing_global.h ${D}/${includedir}
}

SRC_URI += "file://solve_gcc_namespace_issue.patch"
SRC_URI += "file://use_qtdeclarative.patch"

FILES_${PN}-dev = "/usr/lib/*.so ${includedir}"
FILES_${PN} = "/usr/lib/"
