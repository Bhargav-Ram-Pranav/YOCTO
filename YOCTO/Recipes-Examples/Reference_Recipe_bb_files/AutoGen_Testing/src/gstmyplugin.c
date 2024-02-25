#include <gst/gst.h>
#include <config.h> 
static gboolean plugin_init(GstPlugin *plugin) {
  // Initialize your plugin here
  return TRUE;
}

GST_PLUGIN_DEFINE(
    GST_VERSION_MAJOR,
    GST_VERSION_MINOR,
    myplugin,
    "My GStreamer Plugin",
    plugin_init,
    "1.0",
    "LGPL",
    "My GStreamer Plugin",
    "http://example.com"
)

