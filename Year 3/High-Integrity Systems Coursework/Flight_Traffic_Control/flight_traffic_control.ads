pragma SPARK_Mode;
with Spark.Text_Io; use Spark.Text_Io;

package Flight_Traffic_Control is
   
   type One_Clear_State is (NotClear,Clear);
   
   type Choice is (Choice_Clear, Choice_Move);
   
   type Action_Type is (Action_Taxi_Runway,
		       Action_Runway_Taxi,
		       Action_Takeoff,
		       Action_Land,
		       Action_Taxi_Gate,
		       Action_Gate_Taxi,
		       Action_Ascend,
		       Action_Descend);
   
   type One_Area_State is (Occupied,
			      Occupied_Arrival,
			      Occupied_Departure,
			      Clear_For_Departure,
			      Clear_For_Arrival,
			      Free);
   
   type Area_State_Type is
      record
         Taxi,
         Runway,
         Air: One_Area_State;
      end record;
   
   type Clear_State_Type is
      record
         Taxi_Gate,
         Gate_Taxi,
         Taxi_Runway,
         Runway_Taxi,
         Takeoff,
         Land,
         Ascend,
         Descend: One_Clear_State;
      end record;
   
   
   function Clears_Correct (Area_State : Area_State_Type;
			     Clear_State  : Clear_State_Type) 
			    return Boolean is
      ((if Clear_State.Runway_Taxi = Clear
	  then (Area_State.Taxi = Clear_For_Arrival
		  and Area_State.Runway = Occupied_Arrival))
	and
        (if Clear_State.Takeoff = Clear
	   then (Area_State.Air = Clear_For_Departure
		   and Area_State.Runway = Occupied_Departure))
	and
        (if Clear_State.Taxi_Runway = Clear
	   then (Area_State.Runway = Clear_For_Departure
		   and Area_State.Taxi = Occupied_Departure))
	and
        (if Clear_State.Land = Clear
	   then (Area_State.Runway = Clear_For_Arrival
		   and Area_State.Air = Occupied_Arrival))
	
	and
        (if Clear_State.Taxi_Gate = Clear
	   then Area_State.Taxi = Occupied_Arrival)
	
	and
        (if Clear_State.Gate_Taxi = Clear
	   then Area_State.Taxi = Clear_For_Departure)
	
	and
        (if Clear_State.Ascend = Clear
	   then Area_State.Air = Occupied_Departure)
	
	and
        (if Clear_State.Descend = Clear
	   then Area_State.Air = Clear_For_Arrival));
      
      function Area_Occupied(Area_State : One_Area_State) return Boolean is
	 (Area_State = Occupied_Arrival or
	    Area_State = Occupied_Departure or
	    Area_State= Occupied);
      
      
      function Planes_Stay (Area_State_Old, 
			      Area_State_New : Area_State_Type)
			   return Boolean is
	 ((if Area_Occupied(Area_State_Old.Taxi)
	    then  Area_Occupied(Area_State_New.Taxi)) and
	  (if Area_Occupied(Area_State_Old.Runway)
	    then  Area_Occupied(Area_State_New.Runway)) and	   
	  (if Area_Occupied(Area_State_Old.Air)
	    then  Area_Occupied(Area_State_New.Air)));
	 
	 
	 function Move_Planes_Correct (Area_State_Old, 
					 Area_State_New : Area_State_Type;
				       Action: Action_Type)
				      return Boolean is	   
	    ((if Area_State_Old.Taxi = Occupied_Departure
	       then
	      (Area_State_New.Taxi = Occupied_Departure
		 or
		 (Action = Action_Taxi_Runway
		    and Area_State_Old.Runway = Clear_For_Departure
		    and Area_State_New.Taxi = Free
		    and Area_State_New.Runway = Occupied)))
	      and
	      (if Area_State_Old.Taxi = Occupied
		 then
	      Area_State_New.Taxi = Occupied)
	      and
	      (if Area_State_Old.Taxi = Occupied_Arrival
		 then
	      (Area_State_New.Taxi = Occupied_Arrival
		 or
		 (Action = Action_Taxi_Gate
		    and Area_State_New.Taxi = Free)))
	      and
	      (if Area_State_Old.Runway = Occupied_Departure
		 then
	      (Area_State_New.Runway = Occupied_Departure
		 or
		 (Area_State_Old.Air = Clear_For_Departure
		    and
		    Area_State_New.Runway = Free and
		    Area_State_New.Air = Occupied)))
	      and
	      (if Area_State_Old.Runway = Occupied_Arrival
		 then
	      (Area_State_New.Runway = Occupied_Arrival
		 or
		 (Area_State_Old.Taxi = Clear_For_Arrival
		    and
		    Area_State_New.Runway = Free and
		    Area_State_New.Taxi = Occupied)))
	      and
	      (if Area_State_Old.Runway = Occupied
		 then
	      Area_State_New.Runway = Occupied)
	      and
	      (if Area_State_Old.Air = Occupied_Arrival
		 then
	      (Area_State_New.Air = Occupied_Arrival
		 or
		 (Area_State_Old.Runway = Clear_For_Arrival
		    and Area_State_New.Air = Free
		    and Area_State_New.Runway = Occupied)))
	      and
	      (if Area_State_Old.Taxi = Occupied
		 then
	      Area_State_New.Taxi = Occupied));
	    
	    
	    
	    procedure Init(Area_State : out Area_State_Type;
			   Clear_State  : out Clear_State_Type)   With
	      Depends => (Clear_State => null,
			  Area_State => null),
	      Post => (Clears_Correct(Area_State,Clear_State));
	    
	    
	    
	    
	    procedure Open(Area_State : in out Area_State_Type;
			   Clear_State  : in out Clear_State_Type;
			   Action         : in Action_Type;
			   Success       : out Boolean)
	      with 
	      Depends => (Area_State => (Area_State,Action),
			  Success       => (Area_State,Action),
			  Clear_State  => (Area_State,Action,Clear_State)),
	      Pre => (Clears_Correct(Area_State,Clear_State)),	
	      Post=> (Clears_Correct(Area_State,Clear_State) and
			Planes_Stay(Area_State'Old,Area_State));
	    
	    
	    
	    
	    
	    procedure Move(Area_State : in out Area_State_Type;
			   Clear_State  : in out Clear_State_Type;
			   Action         : in Action_Type;
			   Success       : out Boolean) with
	      Depends => (Clear_State  =>  (Area_State, Action, Clear_State),
			  Area_State =>  (Area_State, Action, Clear_State),
			  Success       =>  (Area_State, Action, Clear_State)),
	      Pre => (Clears_Correct(Area_State,Clear_State)),	
	      Post=> (Clears_Correct(Area_State,Clear_State) and
			Move_Planes_Correct(Area_State'Old,Area_State,Action));     
	    
	    
	    
	    
	    
	    procedure Print_One_Clear(The_Clear_State: in One_Clear_State) with
	      Global => (In_Out => Standard_Output),
	      Depends => (Standard_Output => (Standard_Output, The_Clear_State));
	    
	    
	    procedure Print_One_Area_State(the_State: in One_Area_State) with
	      Global => (In_Out => Standard_Output),
	      Depends => (Standard_Output => (Standard_Output, The_State));
	    
	    
	    
	    procedure Print_State(Area_State : in Area_State_Type;
				  Clear_State  : in Clear_State_Type) with
	      Global => (In_Out => Standard_Output),
	      Depends => (Standard_Output => (Standard_Output, Area_State,Clear_State));
	    
	    
	    
	    
	    procedure Get_Action(Action    : out Action_Type;
				 The_Choice : out Choice) with  
	      Global => (In_Out => (Standard_Input,Standard_Output)),
	      Depends => (Standard_Output => (Standard_Output, Standard_Input),
			  Standard_Input =>   Standard_Input,
			  Action =>   Standard_Input,
			  The_Choice =>   Standard_Input);
	    
end Flight_Traffic_Control;
