// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            ar, i, u, ap,
//            af, ak, p, r

final class aj extends ar
{

    private boolean z_iRZ;

    aj()
    {
    }

    void _bTvV()
    {
        z_iRZ = true;
    }

    Member _aur(ClassDef u1, Identifier ak, TypeList p)
    {
        return _aupr(u1, ak, p, null);
    }

    Member _aupr(ClassDef __classDef, Identifier __name, TypeList __typeList, TypeList p1)
    {
        Routine _routine_ = null;
        if(__classDef instanceof ClassDefLocal)
        {
            ClassDefLocal _classDefLocal_ = (ClassDefLocal)__classDef;
            if(super.z_iQZ)
                _routine_ = _classDefLocal_._aaka5(__name, __typeList);
            else
            if(z_iRZ)
                _routine_ = _classDefLocal_.findVirtualRoutine(__name, __typeList);
            else
                _routine_ = _classDefLocal_.findNonVirtualRoutine(__name, __typeList);
        } else
        {
            _routine_ = __classDef.createRoutine(__name, p1, __typeList);
            _routine_.setAddress(-1);
            Module _module_ = __classDef.getModule();
            if(_module_ != null)
            {
                _routine_.setOffset(_module_._a4vI() + 0x10000);
                _module_._trya5V(_routine_);
            }
        }
        return _routine_;
    }
}
