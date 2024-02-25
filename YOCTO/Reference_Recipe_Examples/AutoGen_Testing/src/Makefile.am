AUTOMAKE_OPTIONS = foreign

# Specify the name of your plugin library
noinst_LTLIBRARIES = libmyplugin.la

# List of source files for your plugin
libmyplugin_la_SOURCES = gstmyplugin.c

# Compiler and linker flags
libmyplugin_la_CFLAGS = $(GST_CFLAGS)
libmyplugin_la_LIBADD = $(GST_LIBS)

# Specify where the plugin library should be installed
gstlibdir = $(libdir)/gstreamer-1.0
gstlib_LTLIBRARIES = libmyplugin.la

