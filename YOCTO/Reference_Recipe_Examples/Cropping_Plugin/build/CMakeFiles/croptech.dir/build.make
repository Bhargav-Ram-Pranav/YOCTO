# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.27

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/bhargav/.local/lib/python3.10/site-packages/cmake/data/bin/cmake

# The command to remove a file.
RM = /home/bhargav/.local/lib/python3.10/site-packages/cmake/data/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build

# Include any dependencies generated for this target.
include CMakeFiles/croptech.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/croptech.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/croptech.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/croptech.dir/flags.make

CMakeFiles/croptech.dir/gstcroptech.c.o: CMakeFiles/croptech.dir/flags.make
CMakeFiles/croptech.dir/gstcroptech.c.o: gstcroptech.c
CMakeFiles/croptech.dir/gstcroptech.c.o: CMakeFiles/croptech.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=/home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/croptech.dir/gstcroptech.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/croptech.dir/gstcroptech.c.o -MF CMakeFiles/croptech.dir/gstcroptech.c.o.d -o CMakeFiles/croptech.dir/gstcroptech.c.o -c /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build/gstcroptech.c

CMakeFiles/croptech.dir/gstcroptech.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing C source to CMakeFiles/croptech.dir/gstcroptech.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build/gstcroptech.c > CMakeFiles/croptech.dir/gstcroptech.c.i

CMakeFiles/croptech.dir/gstcroptech.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling C source to assembly CMakeFiles/croptech.dir/gstcroptech.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build/gstcroptech.c -o CMakeFiles/croptech.dir/gstcroptech.c.s

# Object files for target croptech
croptech_OBJECTS = \
"CMakeFiles/croptech.dir/gstcroptech.c.o"

# External object files for target croptech
croptech_EXTERNAL_OBJECTS =

libcroptech.so: CMakeFiles/croptech.dir/gstcroptech.c.o
libcroptech.so: CMakeFiles/croptech.dir/build.make
libcroptech.so: CMakeFiles/croptech.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir=/home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library libcroptech.so"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/croptech.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/croptech.dir/build: libcroptech.so
.PHONY : CMakeFiles/croptech.dir/build

CMakeFiles/croptech.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/croptech.dir/cmake_clean.cmake
.PHONY : CMakeFiles/croptech.dir/clean

CMakeFiles/croptech.dir/depend:
	cd /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build /home/bhargav/Downloads/Yocto/testing/Cropping_Plugin/build/CMakeFiles/croptech.dir/DependInfo.cmake "--color=$(COLOR)"
.PHONY : CMakeFiles/croptech.dir/depend

