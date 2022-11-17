pragma SPARK_Mode;
with AS_Io_Wrapper; use AS_Io_Wrapper;

package body Flight_Traffic_Control
is
   
   
   procedure Init(Area_State : out Area_State_Type;
		  Clear_State  : out Clear_State_Type)  is
        begin
           Clear_State := Clear_State_Type'(Taxi_Gate => NotClear,
                                              Gate_Taxi => NotClear,
                                                Taxi_Runway => NotClear,
                                                Runway_Taxi => NotClear,
                                                Takeoff => NotClear,
                                                Land => NotClear,
                                                Ascend => NotClear,
                                                Descend => NotClear);
           Area_State := Area_State_Type'(Taxi => Free,
                                                  Runway => Free,
                                                  Air  => Free);
        end Init;

	
	
	
	
   procedure Open(Area_State : in out Area_State_Type;
		  Clear_State  : in out Clear_State_Type;
		  Action: in Action_Type;
		  Success: out Boolean) is
   begin
          Success := False;
          if Action  = Action_Taxi_Runway
          then
             if (Area_State.Taxi = Occupied
                 and
                 Area_State.Runway = Free)
             then
                Area_State.Taxi:= Occupied_Departure;
                Area_State.Runway:= Clear_For_Departure;
                Clear_State.Taxi_Runway:= Clear;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action  = Action_Land
          then
             if (    Area_State.Air = Occupied
                 and Area_State.Runway = Free)
             then
                Area_State.Air:= Occupied_Arrival;
                Area_State.Runway:= Clear_For_Arrival;
                Clear_State.Land:= Clear;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Runway_Taxi
            then
               if (Area_State.Runway = Occupied
                   and Area_State.Taxi = Free)
               then
                  Area_State.Runway:= Occupied_Arrival;
                  Area_State.Taxi := Clear_For_Arrival;
                  Clear_State.Runway_Taxi:= Clear;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Takeoff
            then
               if (Area_State.Runway = Occupied
                   and Area_State.Air = Free)
               then
                  Area_State.Runway := Occupied_Departure;
                  Area_State.Air := Clear_For_Departure;
                  Clear_State.Takeoff:= Clear;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Gate_Taxi
            then
               if Area_State.Taxi = Free
               then
                  Area_State.Taxi := Clear_For_Departure;
                  Clear_State.Gate_Taxi:= Clear;
                  Success := True;
               else
                  Success := False;
             end if;
          elsif Action = Action_Descend
            then
               if Area_State.Air = Free
               then
                  Area_State.Air := Clear_For_Arrival;
                  Clear_State.Descend:= Clear;
                  Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Taxi_Gate
          then
             if Area_State.Taxi = Occupied
               then
                  Area_State.Taxi := Occupied_Arrival;
                  Clear_State.Taxi_Gate:= Clear;
                  Success := True;
               else
                  Success := False;
             end if;
          elsif Action = Action_Ascend
          then
             if Area_State.Air = Occupied
             then
                Area_State.Air := Occupied_Departure;
                Clear_State.Ascend:= Clear;
                Success := True;
               else
                  Success := False;
             end if;
          end If;
      end Open;

   
      
    procedure Move(Area_State : in out Area_State_Type;
		   Clear_State  : in out Clear_State_Type;
		   Action: in Action_Type;
		   Success: out Boolean) is
       begin
          Success := False;
          if Action  = Action_Taxi_Runway
          then
             if (Area_State.Taxi = Occupied_Departure
                 and
 		  Area_State.Runway = Clear_For_Departure
 		  and
 	          Clear_State.Taxi_Runway= Clear)
             then
                Clear_State.Taxi_Runway:= NotClear;
                Area_State.Taxi:= Free;
                Area_State.Runway:= Occupied;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action  = Action_Land
          then
             if (    Area_State.Air = Occupied_Arrival
 		      and Area_State.Runway = Clear_For_Arrival
 		      and Clear_State.Land = Clear)
             then
                Clear_State.Land:= NotClear;
                Area_State.Air:= Free;
                Area_State.Runway:= Occupied;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Runway_Taxi
            then
               if (Area_State.Runway = Occupied_Arrival
 		    and Area_State.Taxi = Clear_For_Arrival
 		    and Clear_State.Runway_Taxi = Clear)
               then
                  Clear_State.Runway_Taxi:= NotClear;
                  Area_State.Runway:= Free;
                  Area_State.Taxi := Occupied;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Takeoff
            then
               if (Area_State.Runway = Occupied_Departure
 		    and Area_State.Air = Clear_For_Departure
 		    and Clear_State.Takeoff = Clear)
               then
                  Clear_State.Takeoff:= NotClear;
                  Area_State.Runway := Free;
                  Area_State.Air := Occupied;
                Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Gate_Taxi
            then
               if (Area_State.Taxi = Clear_For_Departure
 		  and Clear_State.Gate_Taxi = Clear)
               then
                  Clear_State.Gate_Taxi:= NotClear;
                  Area_State.Taxi := Occupied;
                  Success := True;
               else
                  Success := False;
             end if;
          elsif Action = Action_Descend
            then
               if (Area_State.Air = Clear_For_Arrival
 		    and Clear_State.Descend= Clear)
               then
                  Clear_State.Descend:= NotClear;
                  Area_State.Air := Occupied;
                  Success := True;
             else
                Success := False;
             end if;
          elsif Action = Action_Taxi_Gate
          then
             if (Area_State.Taxi = Occupied_Arrival
 		   and Clear_State.Taxi_Gate = Clear)
               then
                  Clear_State.Taxi_Gate:= NotClear;
                  Area_State.Taxi := Free;
                  Success := True;
               else
                  Success := False;
             end if;
          elsif Action = Action_Ascend
          then
             if (Area_State.Air = Occupied_Departure
 		  and Clear_State.Ascend = Clear)
               then
                  Clear_State.Ascend:= NotClear;
                  Area_State.Air := Free;
                  Success := True;
               else
                  Success := False;
             end if;
          end if;
       end Move;
     
   

 procedure Print_One_Clear(The_Clear_State: in One_Clear_State) is
    begin
       case The_Clear_State is
	  when NotClear => AS_Put("Not clear");
	  when Clear => AS_Put("Clear");   
       end case;
    end Print_One_Clear;

 procedure Print_One_Area_State(the_State: in One_Area_State) is
    begin
       case The_State is
         when Occupied => AS_Put("Occupied");
         when Occupied_Arrival => AS_Put("Occupied_Arrival");
         when Occupied_Departure => AS_Put("Occupied_Departure");
         when Clear_For_Departure => AS_Put("Clear_For_Departure");
         when Clear_For_Arrival => AS_Put("Clear_For_Arrival");
         when Free => AS_Put("Free");
       end case;
    end Print_One_Area_State;


 procedure Print_State(Area_State : in Area_State_Type;
		       Clear_State  : in Clear_State_Type) is
    begin
       AS_Put_Line("Starting From Gate");
       AS_Put_Line("");
       AS_Put("V ");
       Print_One_Clear(Clear_State.Gate_Taxi);
       AS_Put_Line(" ");
       AS_Put("^ ");
       Print_One_Clear(Clear_State.Taxi_Gate);
       AS_Put_Line(" ");
       AS_Put_Line("");
       AS_Put("Taxi: ");
       Print_One_Area_State(Area_State.Taxi);
       AS_Put_Line(" ");
       AS_Put_Line("");
       AS_Put("V ");
       Print_One_Clear(Clear_State.Taxi_Runway);
       AS_Put_Line(" ");
       AS_Put("^ ");
       Print_One_Clear(Clear_State.Runway_Taxi);
       AS_Put_Line("");
       AS_Put_Line(" ");
       AS_Put("Runway: ");
       Print_One_Area_State(Area_State.Runway);
       AS_Put_Line(" ");
       AS_Put_Line("");
       AS_Put("V ");
       Print_One_Clear(Clear_State.Takeoff);
       AS_Put_Line(" ");
       AS_Put("^ ");
       Print_One_Clear(Clear_State.Land);
       AS_Put_Line(""); 
       AS_Put_Line(" ");
       AS_Put("Air: ");
       Print_One_Area_State(Area_State.Air);
       AS_Put_Line(""); 
       AS_Put_Line("  ");
       AS_Put("V ");
       Print_One_Clear(Clear_State.Ascend);
       AS_Put_Line(" ");
       AS_Put("^ ");
       Print_One_Clear(Clear_State.Descend);
       AS_Put_Line("");
       AS_Put_Line(" ");
       AS_Put("Airspace");
       AS_Put_Line("  ");
    end Print_State;
    
 procedure Get_Action(Action: out Action_Type;
                     The_Choice: out Choice) is
    subtype Index_3 is Integer range 1 .. 3;
    subtype String_3 is String(Index_3);
    Item : String_3;
    subtype Index_1 is Integer range 1 .. 1;
    subtype String_1 is String(Index_1);
    Item_1 : String_1;
    subtype Index_2 is Integer range 1 .. 2;
    subtype String_2 is String(Index_2);
    Item_2 : String_2;
    Stop : Integer;
    Success_Action: Boolean;
    Success_Mode: Boolean;

    begin
       loop
          AS_Put_Line("Select Mode and Action");
          AS_Put_Line("First Letter C for Clear, M for Move");
          AS_Put_Line("Letters 2 and 3 as follows");
          AS_Put_Line("RT for Runway_Taxi");
          AS_Put_Line("TR for Taxi_Runway");
          AS_Put_Line("LD for Land");
          AS_Put_Line("TO for Takeoff");
          AS_Put_Line("TG for Taxi_Gate");
          AS_Put_Line("GT for Gate_Taxi");
          AS_Put_Line("AS for Ascend");
          AS_Put_Line("DE for Descend");
          loop
             AS_Get_Line(Item,Stop);
             exit when not (Stop = 0);
          end loop;
          Success_Mode  := False;
          Item_1 := " ";
          Item_1(1):= Item(1);
          Item_2 := "  ";
          Item_2(1):= Item(2);
          Item_2(2):= Item(3);
          The_Choice := Choice_Clear;
          if Item_1 = "C"
          then
             The_Choice := Choice_Clear;
             Success_Mode:= True;
          elsif Item_1 = "M"
          then
             The_Choice := Choice_Move;
             Success_Mode:= True;
          else
             AS_Put_Line("*** Mode (first letter) not valid. Should be C/M***");
          end if;
          Action := Action_Taxi_Runway;
          if Item_2 = "TR"
          then
             Success_Action := True;
             Action := Action_Taxi_Runway;
          elsif Item_2 = "RT"
          then
             Success_Action := True;
             Action := Action_Runway_Taxi;
          elsif Item_2 = "LD"
          then
             Success_Action := True;
             Action := Action_Land;
          elsif Item_2 = "TO"
          then
             Success_Action := True;
             Action := Action_Takeoff;
          elsif Item_2 = "TG"
          then
             Success_Action := True;
             Action := Action_Taxi_Gate;
          elsif Item_2 = "GT"
          then
             Success_Action := True;
             Action := Action_Gate_Taxi;
          elsif Item_2 = "AS"
          then
             Success_Action := True;
             Action := Action_Ascend;
          elsif Item_2 = "DE"
          then
             Success_Action := True;
             Action := Action_Descend;
          else
             Success_Action:= False;
             AS_Put_Line("*** Action (letter 2 and 3) not valid ***");
          end if;
          exit when (Success_Action and Success_Mode);
       end loop;
    end Get_Action;

















end Flight_Traffic_Control;

