package com.netcracker2.comparator;

import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Unpacking {

    private HashMap<String, Long> map = new HashMap<>();

    public HashMap<String, Long> unpackArchive(final ZipInputStream zis) throws IOException {

        ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                map.put(entry.getName(), entry.getSize());
            }


        return map;
    }
}
