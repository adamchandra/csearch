package acs.csearch

import org.specs2.mutable

object csearchingSpec extends mutable.Specification {

// echo curl http://localhost:8983/solr/update/csv --data-binary @books.csv -H 'Content-type:text/plain; charset=utf-8'
// echo curl http://localhost:8983/solr/update/csv?fieldnames=path,line,text --data-binary - -H 'Content-type:text/plain; charset=utf-8'
// echo curl http://localhost:8983/solr/update/csv?fieldnames=id,path,line,text --data-binary - -H 'Content-type:text/plain; charset=utf-8'

// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head | perl -ne 'BEGIN {$n=0; } print $n++, ",", join(",", split(/:/, $_, 3))' | curl http://localhost:8983/solr/update/csv?fieldnames=id,path,line,text --data-binary - -H 'Content-type:text/plain; charset=utf-8' 
// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head | perl -ne 'BEGIN {$n=0; } print $n++, ",", join(",", split(/:/, $_, 3))' | curl http://localhost:8983/solr/update/csv?fieldnames=id,title,content_type,description --data-binary - -H 'Content-type:text/plain; charset=utf-8' 
// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head | perl -ne 'BEGIN {$n=0; } print $n++, ",", join(",", split(/:/, $_, 3))'
// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head | perl -ne 'BEGIN {$n=0; } print $n++, ",", join(",", split(/:/, $_, 3))' | curl http://localhost:8983/solr/update/csv?fieldnames=id,title,content_type,description --data - -H 'Content-type:text/plain; charset=utf-8' 
// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head | perl -ne 'BEGIN {$n=0; } print $n++, ",", join(",", split(/:/, $_, 3))'
// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head | perl -ne 'BEGIN {$n=0; } print $n++, ",", join(",", split(/:/, $_, 3))' > tmp.csv


// curl http://localhost:8983/solr/update/csv?fieldnames=id,title,content_type,description --data-binary @tmp.csv -H 'Content-type:text/plain; charset=utf-8' 

// csearch -n -f "scalaz.*src/main/.*\.scala" '(object|trait|class)' | head -n 50 | perl -ne 'BEGIN {$n=0; } chomp; print $n++, ",", join(",", map{ s/"/""/g; "\"$_\"" } split(/:/, $_, 3)), "\n"' 

// curl http://localhost:8983/solr/update/csv?fieldnames=id,title,content_type,description --data-binary @tmp.csv -H 'Content-type:text/plain; charset=utf-8' 

// curl http://localhost:8983/solr/update/csv?fieldnames=id,path,line,code --data-binary @tmp.csv -H 'Content-type:text/plain; charset=utf-8' 
// curl http://localhost:8983/solr/update/csv?fieldnames=id,path,line,code&commit=true
// curl http://localhost:8983/solr/update/csv?fieldnames=id,path,line,code&commit=true -H 'Content-type:text/plain; charset=utf-8'
// curl http://localhost:8983/solr/update/csv?fieldnames=id,path,line,code&commit=true --data-binary @tmp.csv -H 'Content-type:text/plain; charset=utf-8' 
// curl http://localhost:8983/solr/update/csv?commit=true 

// GET "http://localhost:8983/solr/select?indent=on&version=2.2&q=code%3AMessage+code%3AValidation+&fq=&start=0&rows=10&fl=*%2Cscore&wt=&explainOther=&hl.fl=&group=true&group.field=path"
// GET "http://localhost:8983/solr/select?indent=on&version=2.2&q=code%3AMessage+code%3AValidation+&fq=&start=0&rows=10&fl=*%2Cscore&wt=&explainOther=&hl.fl=&group=true&group.field=path&group.limit=10"
// GET "http://localhost:8983/solr/select?indent=on&version=2.2&q=code%3AMessage+code%3AValidation+&fq=&start=0&rows=10&fl=*%2Cscore&wt=&explainOther=&hl.fl=&group=true&group.field=path&group.limit=10&wt=json"
// GET "http://localhost:8983/solr/select?indent=on&version=2.2&q=code%3AMessage+code%3AValidation+&fq=&start=0&rows=10&fl=*%2Cscore&explainOther=&hl.fl=&group=true&group.field=path&group.limit=10&wt=json"


// import sys.process._
 
// Process cat new URL("http://databinder.net/dispatch/About") !
// "find src -name *.scala -exec grep null {} ;"  #|  "xargs test -z"  #&&  "echo null-free"  #||  "echo null detected"  !

  import sys.process._

  "calling csearch process" should {
    "just work" in {
      "csearch".run(ProcessLogger(
        (o:String) => { println("out>  "+o) }, 
        (e:String) => { println("err>  "+e) }
      ))

      success
    }

    "grab output" in {
      Process("csearch", Seq("-n", "-f", "scala$", "rightIdentity")).run(ProcessLogger((o:String) => println("out>  "+o), (e:String) => println("err>  "+e)))
      todo

    }
  }

  "Managing the list of directories to be indexed" should {
    
    "add/remove directory at command line" in {
      // pwd -P | PUT http://../paths/
      // pwd -P | DELETE http://../paths/

    }

    "schedule reindexing" in {
      // pwd -P | UPDATE http://../paths/

    }

    "show if directory/file is already indexed" in {
      // pwd -P | HEAD http://../paths/
    }


    "manage multiple csearch indices?" in {
      // pwd -P | PUT http://../pathset/setname/...
    }

  }
  

}

