# Bitbake Cheatsheet 

## Verbose as possible
<pre>
bitbake -vDDD your-recipe
</pre>

## List recipes 
<pre>
bitbake -s
</pre>

## List recipes task
<pre>
bitbake -c listtasks recipe
</pre>

## Run only one task of a recipe
<pre>
bitbake -c your-task your-recipe
</pre>
## Run all tasks for all recipes
<pre>
bitbake world
</pre>
## Bitbake-layers command (help)
<pre>
bitbake-layers -h
</pre>

## Bitbake-layers command

### Add New Layer
<pre>
bitbake-layers add-layer
</pre>
### Remove Layer
<pre>
bitbake-layers remove-layer
</pre>
### Show Layers
<pre>
bitbake-layers show-layers
</pre>
### Show Recipes
<pre>
bitbake-layers show-recipes
</pre>

### Dump Task order of a recipe
<pre>
cat build_directory/tmp/work/machine_toolchain/package_name/package_version/temp/log.task_order
</pre>

## Example Adding task in a Recipe

First list all tasks of a recipe using:

<pre>
bitbake -c listtasks recipe
</pre>

Then add your task where you prefer by adding another task in your recipe:

<pre>
OUT = "${TOPDIR}/tmp/deploy/images/board-name"


do_copy_example() {
    cp ${WORKDIR}/example.txt ${OUT}/example.txt
}

do_copy_example[doc] = "Task added in Recipe"
addtask do_copy_example after task1 before task2
</pre>

Then run your task using:
<pre>
bitbake -c do_copy_example recipe-name
</pre>

## Example adding file into rootfs

<pre>
DESCRIPTION = "Install file into rootfs"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:" 

#take file from files directory
SRC_URI += "\
file://file1 \
file://file2 \
"

#specify where to get the files
S = "${WORKDIR}"


do_install_append() {
    #create custom dir into rootfs
    install -d ${D}/path/to/dir/on/fs
    #copy files inside
    install -m 0644 ${WORKDIR}/file1 ${D}/path/to/dir/on/fs
    install -m 0644 ${WORKDIR}/file2 ${D}/path/to/dir/on/fs
}

FILES_${PN} += "/path/to/dir/on/fs"

</pre>


## Example Copy file into ${DEPLOY_IMAGE_DIR} (Yocto image output)

<pre>
DESCRIPTION = "Install SECO boot tool and uuu-tool"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

UUU_TOOL_BINARY_SRC ?= "git://git.example.com/project.git;"
PROTOCOL ?= "protocol=ssh;"
REPO_USER ?= ""
SRCBRANCH = "master"
SRCREV ="0b47efdb976eeae09e23b077928bdbcc483be80f"


SRC_URI = "${UUU_TOOL_BINARY_SRC}branch=${SRCBRANCH};${PROTOCOL}${REPO_USER}"

S = "${WORKDIR}"

do_install() {
    #create directory
    install -d ${DEPLOY_DIR_IMAGE}/folder1
    #copy file
    cp -r ${WORKDIR}/git/* ${DEPLOY_DIR_IMAGE}/folder1
    #create link
    if [ ! -L ${DEPLOY_DIR_IMAGE}/link ]; then
    ln -s ${DEPLOY_DIR_IMAGE}/folder1/file1 ${DEPLOY_DIR_IMAGE}/file1
    fi   
}
</pre>

# Increase Filesystem size of a .wic/.sdcard

For example setting the RootFS to 2GB would require the following addition to the local.conf file:
<pre>
IMAGE_ROOTFS_SIZE = “2097152”
IMAGE_OVERHEAD_FACTOR = “1.0”
</pre>

# Kill bitbake process

<pre>
$ ps -ef|grep bitbake
$ kill -9 [PPID]
$ ps -ef| grep bitbake |awk '{print $2}' | xargs kill -9
</pre>

# .wks theory (.wic)
<pre>
# short-description: Create SD card image with a boot partition
# long-description:
# Create an image that can be written onto a SD card using dd for use
# with i.MX SoC family.
# It uses SPL and u-boot
#
# The disk layout used is:
#  - ----- --------- --------- --------------
# | | SPL | u-boot  |  /boot  |    rootfs    |
#  - ----- --------- --------- --------------
# ^ ^     ^         ^         ^              ^
# | |     |         |         |              |
# 0 1kiB  69kiB     4MiB   4MiB + 8MiB    4MiB + 8Mib + rootfs + IMAGE_EXTRA_SPACE (default 10MiB)
#
part SPL --source rawcopy --sourceparams="file=SPL" --ondisk mmcblk --no-table --align 1
part u-boot --source rawcopy --sourceparams="file=u-boot.imx" --ondisk mmcblk --no-table --align 69
part /boot --source bootimg-partition --ondisk mmcblk --fstype=vfat --label boot --active --align 4096 --size 8M --extra-space 0
part / --source rootfs --ondisk mmcblk --fstype=ext4 --label root --align 4096

References: https://docs.yoctoproject.org/ref-manual/kickstart.html
References: https://github.com/Freescale/meta-fsl-arm/blob/master/scripts/lib/image/canned-wks/imx-uboot-spl.wks
</pre>

# IF statment example in Yocto recipe (.bb )

```
IMAGE_INSTALL += ${@'linux-firmware imx-gpu-viv kernel-module-imx-gpu-viv' if \
 	(d.getVar('MACHINEOVERRIDES') == 'True') else ''}
```

```
inherit ${@'flatpak-image-variants' if \
	(d.getVar('HAVE_META_FLATPAK') == 'True' and \
	 'flatpak' in d.getVar('DISTRO_FEATURES')) else ''}
inherit ${@'flatpak-repository' if \
	(d.getVar('HAVE_META_FLATPAK') == 'True' and \
	 'flatpak' in d.getVar('DISTRO_FEATURES')) else ''}
```


# IF and Search in a string

```
IMAGE_INSTALL += "${@ 'linux-firmware imx-gpu-viv kernel-module-imx-gpu-viv' if \
                         (d.getVar('MACHINE_SOCARCH_SUFFIX') == '-imx6sx') else ''}"

IMAGE_INSTALL += "${@bb.utils.contains("MACHINE_SOCARCH_SUFFIX", "imx6", "linux-firmware imx-gpu-viv kernel-module-imx-gpu-viv", "", d)}"
```

Referencies: https://github.com/openembedded/bitbake/blob/master/lib/bb/utils.py#L974

# Create vFat image from folder after deploy

core-image-minimal.bbappend
```
do_image_complete() {
    cd ${DEPLOY_DIR_IMAGE}
    dd if=/dev/zero of=boot.img bs=1M count=50
    mkfs.vfat boot.img
    mcopy -i boot.img file.dtb ::file.dtb
    mcopy -i boot.img Image ::Image
    mcopy -i boot.img boot.scr ::boot.scr
}

References: https://stackoverflow.com/questions/22385189/add-files-to-vfat-image-without-mounting
```