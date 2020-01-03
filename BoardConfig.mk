#
# Copyright (C) 2019-2020 The MoKee Open Source Project
#
# SPDX-License-Identifier: Apache-2.0
#

# Inherit from meizu sm8150-common
-include device/meizu/sm8150-common/BoardConfigCommon.mk

DEVICE_PATH := device/meizu/m1973

# Bluetooth
BOARD_BLUETOOTH_BDROID_BUILDCFG_INCLUDE_DIR := $(DEVICE_PATH)/bluetooth/include

# Kernel
TARGET_PREBUILT_KERNEL := $(DEVICE_PATH)/prebuilt/Image.gz-dtb

# HAX: Remove ASAP
BOARD_KERNEL_CMDLINE += androidboot.selinux=permissive

# Fingerprint
SOONG_CONFIG_MEIZU_SM8150_FOD_POS_X := 444
SOONG_CONFIG_MEIZU_SM8150_FOD_POS_Y := 1806
SOONG_CONFIG_MEIZU_SM8150_FOD_SIZE := 189

# Properties
TARGET_SYSTEM_PROP += $(DEVICE_PATH)/system.prop

# Soong namespaces
PRODUCT_SOONG_NAMESPACES += $(DEVICE_PATH)

# inherit from the proprietary version
-include vendor/meizu/m1973/BoardConfigVendor.mk
