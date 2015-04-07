package com.example.ServiceExtended;

/**
 * Created by sanea on 07.04.15.
 */
public class AddFileEvent {
    public AddFileEvent(String fileName, Byte[] fileData){
        _fileName = fileName;
        _fileData = fileData;
    }

    public final String _fileName;
    public final Byte[] _fileData;
}
