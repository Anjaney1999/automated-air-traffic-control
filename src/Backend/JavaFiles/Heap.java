//***********************************************************************************************
//* File: 'Heap.java'
//* THIS IS A GENERATED FILE: DO NOT EDIT. Please edit the Perfect Developer source file instead!
//*
//* Generated from: 'C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/PerfectFiles/Heap.pd'
//* by Perfect Developer version 4.10.02 at 22:21:42 UTC on Sunday April 21st 2019
//* Using command line options:
//* -z1 -el=3 -em=100 -gl=Java -gp=C:/Users/menon/Desktop/university/ThirdYear/COMP30040/ATC/src/Backend/JavaFiles -gs=1 -gv=ISO -gw=100 -gdp=1 -gdo=1 -gdc=4 -gda=1 -gdA=1 -gdl=3 -gdr=1 -gdt=1 -gdi=1 -st=2 -sb=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/builtin.pd -sr=C:/Program Files (x86)/Escher Technologies/Perfect Developer/Bin/rubric.pd -q=0 -@=C:/Users/menon/AppData/Local/Temp/ipfiles.pdd -gk=Backend.JavaFiles
//***********************************************************************************************

package Backend.JavaFiles;

// Packages imported
import Ertsys.*;
import Backend.JavaFiles.*;


public class Heap extends _eAny
{
    protected _eSeq list;
    public int size ()
    {
        return list._oHash ();
    }

    public int parent (int currentPos)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((currentPos < list._oHash ()))) throw new _xPre ("Heap.pd:20,16");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return _eSystem._oDiv (currentPos, 2);
    }

    public int leftChild (int currentPos)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((currentPos < list._oHash ()))) throw new _xPre ("Heap.pd:28,16");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return (2 * currentPos);
    }

    public int rightChild (int currentPos)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((currentPos < list._oHash ()))) throw new _xPre ("Heap.pd:36,16");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return (1 + (2 * currentPos));
    }

    public boolean isLeaf (int currentPos)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((currentPos < list._oHash ()))) throw new _xPre ("Heap.pd:44,16");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return (((currentPos < list._oHash ()) && (_eSystem._oDiv (list._oHash (), 2) <= currentPos))
            ?
        true : false);
    }

    public void update (int index, double distance)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == list._oHash ())))) throw new _xPre ("Heap.pd:59,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((index < list._oHash ()) && (0 <= index)))) throw new _xPre ("Heap.pd:60,21");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((0.0 <= distance))) throw new _xPre ("Heap.pd:61,22");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!(0 == list._oHash ())))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= index))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            _eSeq _vUnshare_66_17 = ((_eSeq) list._lClone ());
            list = _vUnshare_66_17;
            ((Node) list._osIndex (index)).updateDistance (distance);
            heapify_up (index, 0, (list._oHash () - 1));
        }
        else
        {
        }
    }

    public void heapify_up (int pos, int low, int high)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == list._oHash ())))) throw new _xPre ("Heap.pd:77,13");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((((high < list._oHash ()) && (0 <= low)) && (pos <= high)) && (low <= pos))))
                    throw new _xPre ("Heap.pd:78,24");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (((!(0 == pos)) && ((2 * low) <= high)))
        {
            if ((parent (pos) < list._oHash ()))
            {
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= pos))) throw new _xConstraint ("builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                int _vCaptureConstraintCheck_86_38 = parent (pos);
                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                    maxCheckNesting)
                {
                    _eSystem.currentCheckNesting ++;
                    try
                    {
                        if (!((0 <= _vCaptureConstraintCheck_86_38))) throw new _xConstraint (
                            "builtin.pd:91,18");
                    }
                    catch (_xCannotEvaluate _lException)
                    {
                    }
                    _eSystem.currentCheckNesting --;
                }
                if ((((Node) list._oIndex (pos)).distance < ((Node) list._oIndex (
                    _vCaptureConstraintCheck_86_38)).distance))
                {
                    {
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= pos))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        int _vCaptureConstraintCheck_88_35 = parent (pos);
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= _vCaptureConstraintCheck_88_35))) throw new _xConstraint
                                    ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        Heap _vSave_self_88_22 = ((Heap) this._lClone ());
                        _eWrapper__eAny _vSchemaCallTemp_88_22 = (new _eWrapper__eAny (list._oIndex
                            (pos)));
                        _eWrapper__eAny _vSchemaCallTemp_88_34 = (new _eWrapper__eAny (list._oIndex
                            (_vCaptureConstraintCheck_88_35)));
                        _eSystem.swap (_vSchemaCallTemp_88_22, (_eTemplate_0) null,
                            _vSchemaCallTemp_88_34, (_eTemplate_0) null);
                        _eSeq _vUnshare_88_18 = ((_eSeq) list._lClone ());
                        list = _vUnshare_88_18;
                        _vUnshare_88_18._oaIndex (pos, _vSchemaCallTemp_88_22.value);
                        _eSeq _vUnshare_88_30 = ((_eSeq) list._lClone ());
                        list = _vUnshare_88_30;
                        _vUnshare_88_30._oaIndex (_vCaptureConstraintCheck_88_35,
                            _vSchemaCallTemp_88_34.value);
                    }
                    if ((low <= parent (pos)))
                    {
                        Heap _vAntiAlias_self_92_17 = this;
                        heapify_up (_vAntiAlias_self_92_17.parent (pos), low, _vAntiAlias_self_92_17
                            .parent (pos));
                    }
                    else
                    {
                    }
                }
                else
                {
                }
            }
            else
            {
            }
        }
        else
        {
        }
    }

    public void insert (Node node)
    {
        if ((0.0 <= node.distance))
        {
            list = list.append (((_eAny) node));
            heapify_up ((list._oHash () - 1), 0, (list._oHash () - 1));
        }
        else
        {
        }
    }

    public void heapify_down (int pos, int low, int high)
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == list._oHash ())))) throw new _xPre ("Heap.pd:126,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!(((((high < list._oHash ()) && (0 <= low)) && (pos <= high)) && (low <= pos))))
                    throw new _xPre ("Heap.pd:127,30");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((((2 * low) <= high) && (false == isLeaf (pos))))
        {
            if (((leftChild (pos) < list._oHash ()) && (rightChild (pos) < list._oHash ())))
            {
                {
                    int _vCaptureConstraintCheck_135_48 = leftChild (pos);
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= _vCaptureConstraintCheck_135_48))) throw new _xConstraint (
                                "builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!((0 <= pos))) throw new _xConstraint ("builtin.pd:91,18");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                    boolean _vCondResult_135_73;
                    if ((((Node) list._oIndex (_vCaptureConstraintCheck_135_48)).distance < ((Node)
                        list._oIndex (pos)).distance))
                    {
                        _vCondResult_135_73 = true;
                    }
                    else
                    {
                        int _vCaptureConstraintCheck_136_51 = rightChild (pos);
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= _vCaptureConstraintCheck_136_51))) throw new
                                    _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= pos))) throw new _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        _vCondResult_135_73 = (((Node) list._oIndex (_vCaptureConstraintCheck_136_51)
                            ).distance < ((Node) list._oIndex (pos)).distance);
                    }
                    if (_vCondResult_135_73)
                    {
                        int _vCaptureConstraintCheck_138_31 = leftChild (pos);
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= _vCaptureConstraintCheck_138_31))) throw new
                                    _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        int _vCaptureConstraintCheck_138_63 = rightChild (pos);
                        if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                            maxCheckNesting)
                        {
                            _eSystem.currentCheckNesting ++;
                            try
                            {
                                if (!((0 <= _vCaptureConstraintCheck_138_63))) throw new
                                    _xConstraint ("builtin.pd:91,18");
                            }
                            catch (_xCannotEvaluate _lException)
                            {
                            }
                            _eSystem.currentCheckNesting --;
                        }
                        if ((((Node) list._oIndex (_vCaptureConstraintCheck_138_31)).distance < ((
                            Node) list._oIndex (_vCaptureConstraintCheck_138_63)).distance))
                        {
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= pos))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                int _vCaptureConstraintCheck_140_51 = leftChild (pos);
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= _vCaptureConstraintCheck_140_51))) throw new
                                            _xConstraint ("builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                Heap _vSave_self_140_38 = ((Heap) this._lClone ());
                                _eWrapper__eAny _vSchemaCallTemp_140_38 = (new _eWrapper__eAny (list
                                    ._oIndex (pos)));
                                _eWrapper__eAny _vSchemaCallTemp_140_50 = (new _eWrapper__eAny (list
                                    ._oIndex (_vCaptureConstraintCheck_140_51)));
                                _eSystem.swap (_vSchemaCallTemp_140_38, (_eTemplate_0) null,
                                    _vSchemaCallTemp_140_50, (_eTemplate_0) null);
                                _eSeq _vUnshare_140_34 = ((_eSeq) list._lClone ());
                                list = _vUnshare_140_34;
                                _vUnshare_140_34._oaIndex (pos, _vSchemaCallTemp_140_38.value);
                                _eSeq _vUnshare_140_46 = ((_eSeq) list._lClone ());
                                list = _vUnshare_140_46;
                                _vUnshare_140_46._oaIndex (_vCaptureConstraintCheck_140_51,
                                    _vSchemaCallTemp_140_50.value);
                            }
                            if ((leftChild (pos) <= high))
                            {
                                Heap _vAntiAlias_self_143_37 = this;
                                heapify_down (_vAntiAlias_self_143_37.leftChild (pos),
                                    _vAntiAlias_self_143_37.leftChild (pos), high);
                            }
                            else
                            {
                            }
                        }
                        else
                        {
                            {
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= pos))) throw new _xConstraint (
                                            "builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                int _vCaptureConstraintCheck_150_51 = rightChild (pos);
                                if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <=
                                    _eSystem.maxCheckNesting)
                                {
                                    _eSystem.currentCheckNesting ++;
                                    try
                                    {
                                        if (!((0 <= _vCaptureConstraintCheck_150_51))) throw new
                                            _xConstraint ("builtin.pd:91,18");
                                    }
                                    catch (_xCannotEvaluate _lException)
                                    {
                                    }
                                    _eSystem.currentCheckNesting --;
                                }
                                Heap _vSave_self_150_38 = ((Heap) this._lClone ());
                                _eWrapper__eAny _vSchemaCallTemp_150_38 = (new _eWrapper__eAny (list
                                    ._oIndex (pos)));
                                _eWrapper__eAny _vSchemaCallTemp_150_50 = (new _eWrapper__eAny (list
                                    ._oIndex (_vCaptureConstraintCheck_150_51)));
                                _eSystem.swap (_vSchemaCallTemp_150_38, (_eTemplate_0) null,
                                    _vSchemaCallTemp_150_50, (_eTemplate_0) null);
                                _eSeq _vUnshare_150_34 = ((_eSeq) list._lClone ());
                                list = _vUnshare_150_34;
                                _vUnshare_150_34._oaIndex (pos, _vSchemaCallTemp_150_38.value);
                                _eSeq _vUnshare_150_46 = ((_eSeq) list._lClone ());
                                list = _vUnshare_150_46;
                                _vUnshare_150_46._oaIndex (_vCaptureConstraintCheck_150_51,
                                    _vSchemaCallTemp_150_50.value);
                            }
                            if ((rightChild (pos) <= high))
                            {
                                Heap _vAntiAlias_self_153_37 = this;
                                heapify_down (_vAntiAlias_self_153_37.rightChild (pos),
                                    _vAntiAlias_self_153_37.rightChild (pos), high);
                            }
                            else
                            {
                            }
                        }
                    }
                    else
                    {
                    }
                }
            }
            else
            {
            }
        }
        else
        {
        }
    }

    public Node getMin ()
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == list._oHash ())))) throw new _xPre ("Heap.pd:171,15");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        return ((!(0 == list._oHash ())) ?
        ((Node) list.head ()) : new Node (_eSystem._lString ("null"), (char) 0, 0.0));
    }

    public void removeMin ()
    {
        if (_eSystem.enablePre && _eSystem.currentCheckNesting <= _eSystem.maxCheckNesting)
        {
            _eSystem.currentCheckNesting ++;
            try
            {
                if (!((!(0 == list._oHash ())))) throw new _xPre ("Heap.pd:182,19");
            }
            catch (_xCannotEvaluate _lException)
            {
            }
            _eSystem.currentCheckNesting --;
        }
        if ((!(0 == list._oHash ())))
        {
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= 0))) throw new _xConstraint ("builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            int _vCaptureConstraintCheck_187_39 = (list._oHash () - 1);
            if (_eSystem.enableConstraint && _eSystem.currentCheckNesting <= _eSystem.
                maxCheckNesting)
            {
                _eSystem.currentCheckNesting ++;
                try
                {
                    if (!((0 <= _vCaptureConstraintCheck_187_39))) throw new _xConstraint (
                        "builtin.pd:91,18");
                }
                catch (_xCannotEvaluate _lException)
                {
                }
                _eSystem.currentCheckNesting --;
            }
            _eSeq _vUnshare_187_17 = ((_eSeq) list._lClone ());
            list = _vUnshare_187_17;
            _vUnshare_187_17._oaIndex (0, list._oIndex (_vCaptureConstraintCheck_187_39));
            list = list.front ();
            if ((1 < list._oHash ()))
            {
                heapify_down (0, 0, (list._oHash () - 1));
            }
            else
            {
            }
        }
        else
        {
        }
    }

    public int find (_eSeq waypointId, char _t0waypointId)
    {
        if ((!(0 == list._oHash ())))
        {
            boolean _vQuantifierResult_206_14;
            {
                _vQuantifierResult_206_14 = false;
                int _vCaptureCount_node_206_27 = list._oHash ();
                int _vLoopCounter_206_21 = 0;
                for (;;)
                {
                    if (((_vLoopCounter_206_21 == _vCaptureCount_node_206_27) ||
                        _vQuantifierResult_206_14)) break;
                    _vQuantifierResult_206_14 = waypointId._lEqual (((Node) list._oIndex (
                        _vLoopCounter_206_21)).waypoint);
                    if (_vQuantifierResult_206_14)
                    {
                    }
                    else
                    {
                        _vLoopCounter_206_21 = _eSystem._oSucc (_vLoopCounter_206_21);
                    }
                }
            }
            if (_vQuantifierResult_206_14)
            {
                Node _vThatAny_208_37 = null;
                {
                    boolean _vSelectorCondition_208_37;
                    _vSelectorCondition_208_37 = false;
                    int _vCaptureCount_node_208_47 = list._oHash ();
                    int _vLoopCounter_208_41 = 0;
                    for (;;)
                    {
                        if (((_vLoopCounter_208_41 == _vCaptureCount_node_208_47) ||
                            _vSelectorCondition_208_37)) break;
                        _vSelectorCondition_208_37 = waypointId._lEqual (((Node) list._oIndex (
                            _vLoopCounter_208_41)).waypoint);
                        if (_vSelectorCondition_208_37)
                        {
                            _vThatAny_208_37 = ((Node) list._oIndex (_vLoopCounter_208_41));
                        }
                        else
                        {
                        }
                        if (_vSelectorCondition_208_37)
                        {
                        }
                        else
                        {
                            _vLoopCounter_208_41 = _eSystem._oSucc (_vLoopCounter_208_41);
                        }
                    }
                    if (_eSystem.enableThatOrAny && _eSystem.currentCheckNesting <= _eSystem.
                        maxCheckNesting)
                    {
                        _eSystem.currentCheckNesting ++;
                        try
                        {
                            if (!(_vSelectorCondition_208_37)) throw new _xThatOrAny (
                                "Heap.pd:208,37");
                        }
                        catch (_xCannotEvaluate _lException)
                        {
                        }
                        _eSystem.currentCheckNesting --;
                    }
                }
                Node _vLet_requiredNode_208_21 = _vThatAny_208_37;
                return list.findFirst (((_eAny) _vLet_requiredNode_208_21));
            }
            else
            {
                return (- 1);
            }
        }
        else
        {
            return (- 1);
        }
    }

    public Heap ()
    {
        super ();
        list = new _eSeq ();
    }

    public boolean _lEqual (Heap _vArg_11_7)
    {
        if (this == _vArg_11_7)
        {
            return true;
        }
        return _vArg_11_7.list._lEqual (list);
    }

    public boolean equals (_eAny _lArg)
    {
        return _lArg == this || (_lArg != null && _lArg.getClass () == Heap.class && _lEqual ((Heap)
            _lArg));
    }

}


// End of file.
