import random

IPG_IF_MODULE_MIB = "IPG-IF-MODULE-MIB"
IPG_HYBRID_PBR2_MODULE_MIB = "IPG-HYBRID-PBR2-MODULE-MIB"
RFC_1213_MIB = "RFC1213-MIB"
SNMPv2_SMI = "SNMPv2-SMI"
MUX = "MUX"
TXP = "TXP"
PBR1R2 = "PBR1R2"
IF_NOTIFICATION_MESSAGE = "ifNotificationMessage"
HYBRID_NOTIFICATION_MESSAGE = "hybridNotificationMessage"
IF_INDEX = "ifIndex"
SLOT_INDEX = "slotIndex"
IF_NOTIFICATION_SEVERITY = "ifNotificationSeverity"
HYBRID_NOTIFICATION_SEVERITY = "hybridNotificationSeverity"
DEVICES_IP = "166.252.4.186"


class Device:
    def __init__(self, _ip: str, _port: int, _slot_index: int, _key: int, _type: str):
        self.ip = _ip
        self.port = _port
        self.slot_index = _slot_index
        self.key = _key
        self.type = _type


class Severity:
    def __init__(self, _name: str, _number: str):
        self.name = _name
        self.number = _number


class Attribute:
    def __init__(self, _name: str, _value: str):
        self.name = _name
        self.value = _value

    def __str__(self) -> str:
        return "%s = %s" % (self.name, self.value)

    def __repr__(self) -> str:
        return self.__str__()


class SNMPAttribute(Attribute):
    def __init__(self, _prefix: str, _name: str, _value: str):
        Attribute.__init__(self, _name, _value)
        self.name = "%s::%s" % (_prefix, _name)


class Notification:
    def __init__(self, _name: str):
        self.title = "%sNotification" % _name
        self.name = _name

    def __str__(self) -> str:
        return self.title

    def __repr__(self) -> str:
        return self.__str__()


class Trap:
    def __init__(self):
        self.attributes = []

    def add_attribute(self, _attribute: Attribute):
        self.attributes.append(_attribute)

    def __str__(self) -> str:
        return str(self.attributes)

    def __repr__(self) -> str:
        return self.__str__()


def get_ipg_if_module_mib_interface_attributes() -> [str]:
    return ["ifNotificationSeverity",
            "slotIndex",
            "ifNotificationMessage"]


def get_rfc1213_mib_attributes() -> [str]:
    return ["ifIndex"]


def get_txp_mux_interface_properties() -> [str]:
    return ["ifTransceiverLOS",
            "ifTransceiverStatus",
            "ifLOF",
            "ifBDI",
            "ifFECFail",
            "ifLINK",
            "ifTransceiverTemperature",
            "ifTransceiverPin",
            "ifTransceiverPout",
            "ifRemoteLINK",
            "ifMS-AIS",
            "ifMS-RDI"]


def get_pbr1r2_hybrid_properties() -> [str]:
    return ["preampLineInput",
            "preampPowerOut",
            "preampGain",
            "preampCurrent",
            "preampLOS",
            "preampOverCurrent",
            "boosterInput",
            "boosterLine",
            "boosterGain",
            "boosterCurrent",
            "boosterLOS",
            "boosterOverCurrent",
            "raman1Pump",
            "raman1Current",
            "raman1OverCurrent",
            "raman2Pump",
            "raman2Current",
            "raman2OverCurrent",
            "ramanBR",
            "ropaTotalPwrOut",
            "ropa1PwrOut",
            "ropa2PwrOut",
            "ropaCurrent",
            "ropaOverCurrent",
            "br1",
            "br2",
            "HighBRraman",
            "APR"]


def get_txp_mux_system_properties() -> [str]:
    return ["cardAlarm1",
            "cardAlarm2"]


def get_pbr1r2_system_properties() -> [str]:
    return ["cardAlarm1",
            "cardAlarm2",
            "cardTemperature",
            "cardSWNumber"]


def get_hybrid_notifications(_device_type: str) -> [Notification]:
    result = []
    if _device_type == PBR1R2:
        result = get_notifications_of(get_pbr1r2_hybrid_properties())
    return result


def get_interface_notifications(_device_type: str) -> [Notification]:
    result = []
    if _device_type == MUX or _device_type == TXP:
        result = get_notifications_of(get_txp_mux_interface_properties())
    return result


def get_system_notifications(_device_type: str) -> [Notification]:
    result = []
    if _device_type == MUX or _device_type == TXP:
        result = get_notifications_of(get_txp_mux_system_properties())
    elif _device_type == PBR1R2:
        result = get_notifications_of(get_pbr1r2_system_properties())
    return result


def get_txp_mux_interface_notifications() -> [Notification]:
    return get_notifications_of(get_txp_mux_interface_properties())


def get_txp_mux_system_notifications() -> [Notification]:
    return get_notifications_of(get_txp_mux_system_properties())


def get_notifications_of(_items: [str]) -> [Notification]:
    _notifications = []
    for props in _items:
        _notifications.append(Notification(props))
    return _notifications


def get_snmp_modules_attribute(_label: str, _type: str) -> SNMPAttribute:
    ipg_module_att = SNMPAttribute(_label, _type, "None")
    return SNMPAttribute(SNMPv2_SMI, "snmpModules.1.1.4.1.0", ipg_module_att.name)


def get_sys_up_time_attribute() -> SNMPAttribute:
    return SNMPAttribute(RFC_1213_MIB, "sysUpTime.0", "0:13:00:41.66")


def get_connection_cc_attribute(_device_ip: str, _device_port: int) -> Attribute:
    return Attribute("DEVICE.0", "UDP: [%s]:%d->[166.252.4.186]:8001" % (_device_ip, _device_port))


def get_random_severity() -> str:
    return random.choice(["normal", "warning", "critical"])


def get_random_message() -> str:
    return random.choice(["\"\"",
                          "\"Message\"",
                          "\"Short trap Message\"",
                          "\"This is a very large message that explains the trap notification meaning.\""])


def get_random_mux_if_index() -> str:
    return random.choice(["01", "02", "03", "04", "05", "06", "07", "08", "09", "10"])


def get_random_error() -> str:
    return random.choice(["-inf", "error", "+inf"])


def get_random_txp_if_index() -> str:
    return random.choice(["01", "02", "03", "04"])


def get_random_if_index(_device_type: str) -> str:
    if _device_type == MUX:
        return get_random_mux_if_index()
    elif _device_type == TXP:
        return get_random_txp_if_index()
    else:
        return ""


def get_severity_label(_device_type: str):
    result = ""
    if _device_type == MUX or _device_type == TXP:
        result = IF_NOTIFICATION_SEVERITY
    elif _device_type == PBR1R2:
        result = HYBRID_NOTIFICATION_SEVERITY
    return result


def get_message_label(_device_type: str):
    result = ""
    if _device_type == MUX or _device_type == TXP:
        result = IF_NOTIFICATION_MESSAGE
    elif _device_type == PBR1R2:
        result = HYBRID_NOTIFICATION_MESSAGE
    return result


def get_module_label(_device_type: str) -> str:
    result = ""
    if _device_type == MUX or _device_type == TXP:
        result = IPG_IF_MODULE_MIB
    elif _device_type == PBR1R2:
        result = IPG_HYBRID_PBR2_MODULE_MIB
    return result


def generate_hybrid_traps(_device: Device, _times: int):
    for i in range(_times):
        for _notification in get_hybrid_notifications(_device.type):
            trap = Trap()

            label = get_module_label(_device.type)
            trap.add_attribute(get_connection_cc_attribute(_device.ip, _device.port))
            trap.add_attribute(SNMPAttribute(label, get_severity_label(_device.type), get_random_severity()))
            trap.add_attribute(SNMPAttribute(label, SLOT_INDEX, str(_device.slot_index)))
            trap.add_attribute(SNMPAttribute(label, _notification.name, get_random_error()))
            trap.add_attribute(SNMPAttribute(label, get_message_label(_device.type), get_random_message()))

            print("	".join(map(str, [item for item in trap.attributes])))


def generate_interface_traps(_device: Device, _times: int):
    for i in range(_times):
        for _notification in get_interface_notifications(_device.type):
            trap = Trap()

            label = get_module_label(_device.type)
            trap.add_attribute(get_connection_cc_attribute(_device.ip, _device.port))
            trap.add_attribute(get_sys_up_time_attribute())
            trap.add_attribute(get_snmp_modules_attribute(label, _notification.title))
            trap.add_attribute(SNMPAttribute(label, get_severity_label(_device.type), get_random_severity()))
            trap.add_attribute(SNMPAttribute(label, SLOT_INDEX, str(_device.slot_index)))
            trap.add_attribute(SNMPAttribute(RFC_1213_MIB, IF_INDEX, "%d%s"
                                             % (_device.slot_index, get_random_if_index(_device.type))))
            trap.add_attribute(SNMPAttribute(label, _notification.name, get_random_error()))
            trap.add_attribute(SNMPAttribute(label, get_message_label(_device.type), get_random_message()))

            print("	".join(map(str, [item for item in trap.attributes])))


def generate_pbr1r2_system_traps(_device: Device, _times: int):
    for i in range(_times):
        for _notification in get_system_notifications(_device.type):
            trap = Trap()

            label = get_module_label(_device.type)
            trap.add_attribute(get_connection_cc_attribute(_device.ip, _device.port))
            trap.add_attribute(SNMPAttribute(label, get_severity_label(_device.type), get_random_severity()))
            trap.add_attribute(SNMPAttribute(label, SLOT_INDEX, str(_device.slot_index)))
            trap.add_attribute(SNMPAttribute(label, _notification.name, get_random_error()))
            trap.add_attribute(SNMPAttribute(label, get_message_label(_device.type), get_random_message()))

            print("	".join(map(str, [item for item in trap.attributes])))


def generate_txp_mux_system_traps(_device: Device, _times: int):
    for i in range(_times):
        for _notification in get_system_notifications(_device.type):
            trap = Trap()

            label = get_module_label(_device.type)
            trap.add_attribute(get_connection_cc_attribute(_device.ip, _device.port))
            trap.add_attribute(get_sys_up_time_attribute())
            trap.add_attribute(get_snmp_modules_attribute(label, _notification.title))
            trap.add_attribute(SNMPAttribute(label, get_severity_label(_device.type), get_random_severity()))
            trap.add_attribute(SNMPAttribute(label, SLOT_INDEX, str(_device.slot_index)))
            trap.add_attribute(SNMPAttribute(label, _notification.name, get_random_error()))
            trap.add_attribute(SNMPAttribute(label, get_message_label(_device.type), get_random_message()))

            print("	".join(map(str, [item for item in trap.attributes])))


def generate_system_traps(_device: Device, _times: int):
    if _device.type == MUX or _device.type == TXP:
        generate_txp_mux_system_traps(_device, _times)
    elif _device.type == PBR1R2:
        generate_pbr1r2_system_traps(_device, _times)


def generate_non_system_traps(_device: Device, _times: int):
    if _device.type == MUX or _device.type == TXP:
        generate_interface_traps(_device, _times)
    elif _device.type == PBR1R2:
        generate_hybrid_traps(_device, _times)


def get_devices():
    return [
        # Device(DEVICES_IP, 8001, 2, 23, TXP),
        # Device(DEVICES_IP, 8179, 10, 20, MUX),
        Device(DEVICES_IP, 8179, 5, 22, PBR1R2)
    ]


if __name__ == '__main__':
    for device in get_devices():
        generate_system_traps(device, 1)
        generate_non_system_traps(device, 1)

# TXP/MUX - SYSTEM-TRAP
# DEVICE.0 = UDP: [166.252.4.186]:8001->[166.252.4.186]:8001
# RFC1213-MIB::sysUpTime.0 = 0:13:00:41.65
# SNMPv2-SMI::snmpModules.1.1.4.1.0 = IPG-IF-MODULE-MIB::cardRebootNotification
# IPG-IF-MODULE-MIB::systemNotificationSeverity = warning
# IPG-IF-MODULE-MIB::slotIndex = 10
# IPG-IF-MODULE-MIB::cardSWNumber = error
# IPG-IF-MODULE-MIB::systemNotificationMessage = "warning Trap"

# TXP/MUX - NON-SYSTEM-TRAP
# DEVICE.0 = UDP: [166.252.4.186]:8001->[166.252.4.186]:8001
# RFC1213-MIB::sysUpTime.0 = 0:13:00:41.66
# SNMPv2-SMI::snmpModules.1.1.4.1.0 = IPG-IF-MODULE-MIB::ifTransceiverLOSNotification
# IPG-IF-MODULE-MIB::ifNotificationSeverity = critical
# IPG-IF-MODULE-MIB::slotIndex = 10
# RFC1213-MIB::ifIndex = 1001
# IPG-IF-MODULE-MIB::ifTransceiverLOS = "-inf"
# IPG-IF-MODULE-MIB::ifNotificationMessage = "channel 3"

# PBR1R2 - NON-SYSTEM-TRAP
# DEVICE.0 = UDP: [192.168.210.179]:161->[192.168.210.50]:162
# IPG-HYBRID-PBR2-MODULE-MIB::systemNotificationSeverity = critical
# IPG-HYBRID-PBR2-MODULE-MIB::slotIndex = 5
# IPG-HYBRID-PBR2-MODULE-MIB::alarm2 = error
# IPG-HYBRID-PBR2-MODULE-MIB::systemNotificationMessage = ""
