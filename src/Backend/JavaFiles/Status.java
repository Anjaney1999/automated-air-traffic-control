//***********************************************************************************************
//* File: 'Status.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Status.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public final class Status extends _eEnumBase
{
    public Status ()
    {
    }

    public Status (int _lArg1)
    {
        super (_lArg1);
    }

    public static _eSeq _oRange (int _lArg1, int _lArg2)
    {
        _eSeq _lResult = new _eSeq ();
        while (_lArg1 <= _lArg2) _lResult = _lResult._lAppend (new Status (_lArg1 ++));
        return _lResult;
    }

    public final static int noStatus = 0, green = 1, orange = 2, red = 3;
    private final static String [] _lnames =
    {
        "noStatus", "green", "orange", "red"
    };

    public static _eSeq _ltoString (int _larg)
    {
        return _eSystem._lString (_lnames [_larg]);
    }

    public _eSeq _rtoString ()
    {
        return _eSystem._lString (_lnames [value]);
    }

}


// End of file.
