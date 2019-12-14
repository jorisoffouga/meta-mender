DESCRIPTION = "Mender USB recipe for update via USB"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " file://mender-usb.rules \
            file://mender-usb@.service \
"

inherit systemd

do_install_append(){
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/mender-usb.rules ${D}${sysconfdir}/udev/rules.d/
    install -d ${D}${systemd_unitdir}/system
    install -m 644 ${WORKDIR}/mender-usb@.service ${D}${systemd_unitdir}/system/
}


FILES_${PN} += "${systemd_unitdir}/system/mender-usb@.service \
                ${sysconfdir}/udev/rules.d/mender-usb.rules \
"

