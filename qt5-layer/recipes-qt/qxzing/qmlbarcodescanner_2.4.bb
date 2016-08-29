DESCRIPTION = "QML barcode scanner"

require qxzing.inc

DEPENDS = "qxzing"

QMAKE_PROFILES = "${S}/examples/QMLBarcodeScanner/QMLBarcodeReader.pro"

do_install () {
       install -m 755 -d ${D}/${bindir}
       install -m 755 ${B}/QMLBarcodeReader ${D}/${bindir}
}

SRC_URI += "file://fix_linking.patch"
