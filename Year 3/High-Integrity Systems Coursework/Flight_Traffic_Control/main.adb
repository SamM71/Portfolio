pragma SPARK_Mode;
with AS_Io_Wrapper; use AS_Io_Wrapper;
-- with Spark.Text_Io; use Spark.Text_Io;
with Flight_Traffic_Control; use Flight_Traffic_Control;


procedure Main
is
   subtype Choice is Flight_Traffic_Control.Choice;
   subtype Area_State_Type is Flight_Traffic_Control.Area_State_Type;
   subtype Clear_State_Type is Flight_Traffic_Control.Clear_State_Type;
   Success: Boolean;
   Action: Action_Type;
   The_Choice: Choice;
   
   Area_State : Area_State_Type;
   Clear_State  : Clear_State_Type;
   
begin
   As_Init_Standard_Input;
   As_Init_Standard_Output;
   Init(Area_State,Clear_State);
   loop
      pragma Loop_Invariant(Clears_Correct (Area_State,Clear_State  ));
      As_Put_Line(" ");
      Print_State(Area_State,Clear_State);
      As_Put_Line(" ");
      Get_Action(Action, The_Choice);
      if The_Choice = Choice_Clear
      then
	 Open(Area_State, Clear_State,Action, Success);
      else
	 Move(Area_State, Clear_State, Action, Success);
      end if;
      if Success
      then
	 As_Put_Line("*** Success *** ");
      else
	 As_Put_Line("*** Route not Allowed *** ");
	 
      end if;
   end loop;
end Main;
