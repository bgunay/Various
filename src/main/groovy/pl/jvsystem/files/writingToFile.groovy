package pl.jvsystem.files

File file = new File('D:\\samples\\jhipster-test\\src\\main\\resources\\config\\liquibase\\bikes.csv')
//file.text = "Ala ma kota"
//file.bytes = [65, 66, 76, 68] as byte[]
//file << "Append New line"

def ln = System.getProperty('line.separator')

file.withPrintWriter { PrintWriter writer ->
    writer.write("id;name${ln}")
    80.times { index ->
        writer.write("${index+1};"+UUID.randomUUID().toString().substring(0,8)+"${ln}")
    }
    writer.flush()
}