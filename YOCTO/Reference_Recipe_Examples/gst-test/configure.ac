AC_INIT([myfilter], [1.0], [your-email@example.com])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
AC_CONFIG_HEADERS([config.h])
AC_PROG_CC
PKG_CHECK_MODULES([GST], [gstreamer-1.0])
AC_SUBST([GST_CFLAGS])
AC_SUBST([GST_LIBS])
AC_CONFIG_FILES([Makefile])
AC_OUTPUT


