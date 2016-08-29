LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://source/zxing/zxing/ZXing.h;beginline=2;endline=16;md5=9afafa1044b198e91451864da9c6a1e3"

inherit qmake5

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

QBRANCH = "release_v2.4"

SRC_URI = "git://git.code.sf.net/p/qzxing/code;protocol=git;branch=${QBRANCH}"
