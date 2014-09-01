package pl.jvsystem.builders

bldr = new TodoBuilderWithSupport()

bldr.build {
	Prepare_Vacation(start: '02/15', end: '02/22') {
		Reserve_Flight(on: '01/01', status: 'done')
		Reserve_Hotel(on: '01/02')
		Reserver_Car(on: '01/02')
		Go_Sleep
	}
	Buy_New_Mac {
		Install_QuickSilver
		Install_TextMate
		Install_Groovy {
			Run_all_tests
		}
	}
}