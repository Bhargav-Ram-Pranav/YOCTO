AC_INIT([my_gst_plugin], [1.0], [your@email.com])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
LT_INIT
AC_CONFIG_SRCDIR([src/gstmyplugin.c])
AC_CONFIG_HEADERS([config.h])
AC_PROG_CC

# Check for GStreamer
dnl GStreamer 1.0
PKG_CHECK_MODULES([GST], [gstreamer-1.0 >= 1.0.0])
AC_CONFIG_FILES([src/Makefile include/Makefile])

AC_CONFIG_FILES([Makefile src/Makefile])
AC_OUTPUT

