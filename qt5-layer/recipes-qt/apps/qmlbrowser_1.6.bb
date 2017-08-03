DESCRIPTION = "Atmel QT home automation demo"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qml/webbrowser/webbrowser.qml;endline=40;md5=a78c797054f097540ddb57fc9212183d"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "qtquick1"
inherit qmake5

SRC_URI = "https://github.com/linux4sam/qml-browser/archive/v${PV}.zip"

SRC_URI[md5sum] = "5ae371e56282966975a727b723df273b"
SRC_URI[sha256sum] = "3a4f9974c8c53dc3b3eed90de421650cd93dd2cd295c7ecd88844af250e3019d"

S = "${WORKDIR}/qml-browser-${PV}"

inherit pkgconfig

FILES_${PN}-dbg = " \
  /opt/browser/bin/.debug \
  /opt/browser/bin/.debug/browser \
  /usr/* \
"

FILES_${PN} = " \
  /opt/browser/bin/browser \
  /opt/browser/resources/* \
  /opt/browser/qml/* \
  /opt/browser/opt/* \
  /opt/ApplicationL* \
"

do_install() {
	make INSTALL_ROOT=${D} install
	cd ${B}/opt/
	    for file in $(find browser ApplicationLauncher -type f); do
        if [ -x ${file} ]; then
            PERM="755"
        else
            PERM="644"
        fi
        echo install -m ${PERM} -D ${file} ${D}/opt/${file}
        install -m ${PERM} -D ${file} ${D}/opt/${file}
    done
}