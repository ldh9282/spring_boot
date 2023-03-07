const person = {
    name: 'Ranga karanam',
    address: {
        line1: 'Baker Street',
        city: 'London',
        country: 'UK'
    },
    profiles: ['twitter', 'linkdin', 'instagram'],
    printprofile: () => {
        person.profiles.map(
            profile => console.log(profile)
            
        )
        console.log(person.profiles[0]);
    }

}


export default function LearningJavascript() {
    return (
        <>
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.profiles[0]}</div>
            <div>{ person.printprofile() }</div>
        </>
    )
}