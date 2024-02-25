plugin_LTLIBRARIES = libgstfilter.la

libgstaja_la_CPPFLAGS = \
	$(GST_PLUGINS_BAD_CFLAGS) \
	$(GST_PLUGINS_BASE_CFLAGS) \
	$(GST_BASE_CFLAGS) \
	$(GST_CFLAGS) \
	-DAJALinux=1 \
	-DAJA_LINUX=1 \
	
libgstaja_la_LIBADD = \
	-L$(srcdir)/../../../../lib \
	$(GST_PLUGINS_BASE_LIBS) \
	-lgstaudio-1.0 \
	-lgstvideo-1.0 \
	-lajabase \
	-lpthread \
	-lrt \
	$(GST_BASE_LIBS) \
	$(GST_LIBS) \
	$(LIBM)

libgstaja_la_LDFLAGS = $(GST_PLUGIN_LDFLAGS)
libgstaja_la_LIBTOOLFLAGS = $(GST_PLUGIN_LIBTOOLFLAGS)

# sources used to compile this plug-in
libgstaja_la_SOURCES = \
	gstexamplefilter.c 
	

# headers we need but don't want installed
noinst_HEADERS = \
	gstexamplefilter.h \
	
	
