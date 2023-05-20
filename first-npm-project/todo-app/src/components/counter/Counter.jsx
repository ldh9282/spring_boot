import { useState } from 'react';
import './Counter.css'
import CounterButton from './CounterButton';
import ResetButton from './ResetButton';
import TotalCount from './TotalCount';

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by);
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by);
    }

    function resetCounter() {
        setCount(0);
    }
    
    return (
        <div className='Counter'>
            <TotalCount count={count} />
            <CounterButton by={1} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>      
            <CounterButton by={2} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>      
            <CounterButton by={5} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction}/>      
            <ResetButton resetCounter={resetCounter} />
        </div>
    )

    
}


