package org.omg.CosNaming;


/**
* org/omg/CosNaming/BindingListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from d:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u25/1677/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, October 7, 2014 2:27:04 PM PDT
*/


/**
   * List of Bindings.
   */
public final class BindingListHolder implements org.omg.CORBA.portable.Streamable
{
  public Binding value[] = null;

  public BindingListHolder ()
  {
  }

  public BindingListHolder (Binding[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BindingListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BindingListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BindingListHelper.type ();
  }

}
