import React, {useState, useEffect} from "react";
import {Button} from "react-bootstrap";
import {AiOutlineSearch} from "react-icons/ai";

const SearchItem = ({setKeyword}) => {
    const [input, setInput ] = useState('');

    const handleChange = (e) => {
        setInput(e.target.value);
      /*  console.log(e);*/
        setKeyword(e.target.value);
    }

    const search = (e) => {
        e.preventDefault();
    };

    function clear(){
        setInput('');
        setKeyword('');

    };

    return (
        <>
        <div>
            <form className="search-wrapper" onSubmit={search}>
                <input
                    type='text'
                    className='form-control search_input'
                    aria-label = 'Text input'
                    placeholder= 'Search'
                    value={input}
                    style={{paddingTop:5}}
                    onChange={handleChange}/>
                <Button id="button" type="reset" value="Reset"
                        onClick={clear} size="sm">Reset
                </Button>
              {/*  <Button id="button" type='submit'
                         size="sm">
                    <AiOutlineSearch/>
                </Button>*/}
            </form>
        </div>
            </>
    );

};

 export default SearchItem;

