import React, { useState } from 'react';
import axios from 'axios';


interface Pokemon {
name: string;
abilities: string[];
stats: Record<string, number>;
type: string;
image: string;
}



